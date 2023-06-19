package com.qsck.weather.network

import com.qsck.weather.model.Geo
import com.qsck.weather.model.WeatherInfo
import com.qsck.weather.common.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("${Constant.URL_VERSION}/geocode/geo")
    suspend fun getGeo(
        @Query("address") address: String,
        @Query("key") key: String = Constant.KEY_WEB
    ): Geo

    @GET("${Constant.URL_VERSION}/weather/weatherInfo")
    suspend fun getWeatherInfo(
        @Query("city") adCode: String,
        @Query("extensions") extensions: String = Constant.WEATHER_TYPE,
        @Query("key") key: String = Constant.KEY_WEB,
    ): WeatherInfo
}