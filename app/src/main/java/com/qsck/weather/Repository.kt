package com.qsck.weather

import android.util.Log
import com.qsck.weather.common.Utils
import com.qsck.weather.common.getAdCode
import com.qsck.weather.common.getWeatherTomorrow
import com.qsck.weather.common.isTimeOut
import com.qsck.weather.db.AppDatabase
import com.qsck.weather.model.AdCode
import com.qsck.weather.model.Weather
import com.qsck.weather.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(db: AppDatabase, private val networkService: NetworkService) {

    private val weatherDao = db.weatherDao()
    private val adCodeDao = db.adCodeDao()

    suspend fun getAdCode(address: String): String? {
        Log.d("Repository", "getAdCode address: $address")

        return adCodeDao.findByAddress(address)
            ?.takeUnless { it.requestTime.isTimeOut() }?.adcode?.let {
            Log.d("Repository", "findByAddress is suc!")
            it
        } ?: run {
            Log.d("Repository", "findByAddress is null or time out, fetchAdCodeFromNetwork")
            fetchAdCodeFromNetwork(address)?.adcode
        }
    }

    private suspend fun fetchAdCodeFromNetwork(address: String): AdCode? {
        val adCode = networkService.getGeo(address).getAdCode(address)
        if (adCode != null) {
            adCodeDao.insertAll(adCode)
        }

        return adCode
    }


    suspend fun getWeatherTomorrow(adCode: String): Weather? = withContext(Dispatchers.IO) {
        val tomorrow = Utils.getTomorrow()
        Log.d("Repository", "tomorrow: $tomorrow")

        val weather = weatherDao.findByAdCode(adCode, tomorrow)
        return@withContext if (weather == null || weather.requestTime.isTimeOut()) {
            Log.d("Repository", "findByAdCode is null or time out, fetchWeatherFromNetwork")
            fetchWeatherFromNetwork(adCode)
        } else {
            weather
        }
    }

    private suspend fun fetchWeatherFromNetwork(adCode: String): Weather? {
        val weatherTomorrow =
            networkService.getWeatherInfo(adCode).getWeatherTomorrow() ?: return null
        Log.d("Repository", "fetchWeatherFromNetwork insert weatherTomorrow: $weatherTomorrow")
        weatherDao.insertAll(weatherTomorrow)
        return weatherTomorrow
    }


    companion object {
        private var instance: Repository? = null

        fun getInstance(db: AppDatabase, networkService: NetworkService): Repository {
            if (instance == null) {
                synchronized(Repository::class) {
                    if (instance == null) {
                        instance = Repository(db, networkService)
                    }
                }
            }
            return instance!!
        }
    }

}