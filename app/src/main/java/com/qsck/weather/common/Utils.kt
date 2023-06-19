package com.qsck.weather.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Utils {

    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    fun getTomorrow(): String {
        return Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, 1)
        }.time.let {
            formatter.format(it)
        }
    }

    fun getWeek(week: String): String {
        return when (week) {
            "1" -> "周一"
            "2" -> "周二"
            "3" -> "周三"
            "4" -> "周四"
            "5" -> "周五"
            "6" -> "周六"
            "7" -> "周日"
            else -> ""
        }
    }
}