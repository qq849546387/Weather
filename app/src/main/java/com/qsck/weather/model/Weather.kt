package com.qsck.weather.model

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "weathers", primaryKeys = ["ad_code", "date"])
data class Weather(
    val date: String,
    @ColumnInfo(name = "day_power")
    val daypower: String,
    @ColumnInfo(name = "day_temp")
    val daytemp: String,
    @ColumnInfo(name = "day_temp_float")
    val daytempFloat: String,
    @ColumnInfo(name = "day_weather")
    val dayweather: String,
    @ColumnInfo(name = "day_wind")
    val daywind: String,
    @ColumnInfo(name = "night_power")
    val nightpower: String,
    @ColumnInfo(name = "night_temp")
    val nighttemp: String,
    @ColumnInfo(name = "night_temp_float")
    val nighttempFloat: String,
    @ColumnInfo(name = "night_weather")
    val nightweather: String,
    @ColumnInfo(name = "night_wind")
    val nightwind: String,
    val week: String,
    @ColumnInfo("ad_code")
    val adcode: String,
    val city: String,
    @ColumnInfo("report_time")
    val reporttime: String,
    @ColumnInfo("request_time")
    val requestTime: Long = System.currentTimeMillis()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Weather

        return adcode == other.adcode
    }

    override fun hashCode(): Int {
        return adcode.hashCode()
    }
}
