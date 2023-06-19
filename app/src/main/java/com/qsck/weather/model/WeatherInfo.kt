package com.qsck.weather.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName


data class WeatherInfo(
    @SerializedName("count")
    val count: String,
    @SerializedName("forecasts")
    val forecasts: List<Forecast>,
    @SerializedName("info")
    val info: String,
    @SerializedName("infocode")
    val infocode: String,
    @SerializedName("status")
    val status: String
)

data class Forecast(
    @SerializedName("adcode")
    val adcode: String,
    @SerializedName("casts")
    val casts: List<Cast>,
    @SerializedName("city")
    val city: String,
    @SerializedName("province")
    val province: String,
    @SerializedName("reporttime")
    val reporttime: String
)

data class Cast(
    @SerializedName("date")
    val date: String,
    @ColumnInfo(name = "day_power")
    @SerializedName("daypower")
    val daypower: String,
    @ColumnInfo(name = "day_temp")
    @SerializedName("daytemp")
    val daytemp: String,
    @ColumnInfo(name = "day_temp_float")
    @SerializedName("daytemp_float")
    val daytempFloat: String,
    @ColumnInfo(name = "day_weather")
    @SerializedName("dayweather")
    val dayweather: String,
    @ColumnInfo(name = "day_wind")
    @SerializedName("daywind")
    val daywind: String,
    @ColumnInfo(name = "night_power")
    @SerializedName("nightpower")
    val nightpower: String,
    @ColumnInfo(name = "night_temp")
    @SerializedName("nighttemp")
    val nighttemp: String,
    @ColumnInfo(name = "night_temp_float")
    @SerializedName("nighttemp_float")
    val nighttempFloat: String,
    @ColumnInfo(name = "night_weather")
    @SerializedName("nightweather")
    val nightweather: String,
    @ColumnInfo(name = "night_wind")
    @SerializedName("nightwind")
    val nightwind: String,
    @SerializedName("week")
    val week: String
)