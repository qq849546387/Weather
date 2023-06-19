package com.qsck.weather

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.qsck.weather.db.WeatherDb
import com.qsck.weather.model.Weather
import com.qsck.weather.network.NetworkService
import com.qsck.weather.network.ServiceCreator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val weathers = intArrayOf(
        R.string.city_beijing,
        R.string.city_shanghai,
        R.string.city_guangzhou,
        R.string.city_shenzhen,
        R.string.city_suzhou,
        R.string.city_shenyang,
    )

    private val networkService = ServiceCreator.create(NetworkService::class.java)
    private val repository = Repository.getInstance(WeatherDb.getDb(application), networkService)

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: Flow<Weather> = _weather.filterNotNull()

    fun getWeathers(context: Context) {
        weathers.forEach {
            getWeatherTomorrow(context.getString(it))
        }
    }

    private fun getWeatherTomorrow(address: String) {
        log("getWeatherTomorrow address:　$address")

        viewModelScope.launch {
            val adCode = repository.getAdCode(address)
                ?: return@launch log("getWeatherTomorrow address is error")
            log("getWeatherTomorrow adCode:　$adCode")

            repository.getWeatherTomorrow(adCode)?.let {
                log("getWeatherTomorrow weather:　$it")
                _weather.value = it
            }
        }
    }

    private fun log(s: String) {
        Log.d("MainViewModel", s)
    }

}