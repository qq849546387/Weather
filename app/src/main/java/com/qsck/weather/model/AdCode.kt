package com.qsck.weather.model

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "adcodes", primaryKeys = ["ad_code"])
data class AdCode(
    @ColumnInfo("ad_code")
    val adcode: String,
    val city: String,
    @ColumnInfo("find_address")
    val findAddress: String,
    @ColumnInfo("request_time")
    val requestTime: Long = System.currentTimeMillis()
)
