package com.qsck.weather.network

import com.qsck.weather.common.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

}