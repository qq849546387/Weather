package com.qsck.weather.common

import android.content.res.Resources
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.flowWithLifecycle
import com.qsck.weather.model.AdCode
import com.qsck.weather.model.Geo
import com.qsck.weather.model.Weather
import com.qsck.weather.model.WeatherInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import java.security.AccessController.getContext


fun WeatherInfo.getWeatherTomorrow(): Weather? {
    val forecast = forecasts.first()
    return forecast.casts.takeIf { it.size > 1 }?.get(1)?.let {
        Weather(
            it.date,
            it.daypower,
            it.daytemp,
            it.daytempFloat,
            it.dayweather,
            it.daywind,
            it.nightpower,
            it.nighttemp,
            it.nighttempFloat,
            it.nightweather,
            it.nightwind,
            it.week,
            forecast.adcode,
            forecast.city,
            forecast.reporttime
        )
    }
}

fun Geo.getAdCode(address: String): AdCode? {
    return geocodes.takeIf { it.isNotEmpty() }?.first()?.let {
        AdCode(
            it.adcode,
            it.city,
            address
        )
    }
}

fun <T> Flow<T>.collectWithLifecycle(
    lifecycle: Lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    collector: FlowCollector<T>
) {
    lifecycle.coroutineScope.launch {
        flowWithLifecycle(lifecycle, minActiveState).collect(collector)
    }
}

fun Long.isTimeOut(outTime: Long = 1000 * 60 * 30): Boolean {
    return System.currentTimeMillis() - this > outTime
}

inline val @receiver:StringRes Int.string: String
    @Composable
    get() {
        LocalContext.current
        return stringResource(this)
    }

inline val Int.dp: Int
    get() = run {
        return toFloat().dp
    }

inline val Float.dp: Int
    get() = run {
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }