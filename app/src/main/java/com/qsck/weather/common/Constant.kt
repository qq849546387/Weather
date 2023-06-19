package com.qsck.weather.common

object Constant {

    /**
     * 服务示例
     *
     * https://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=<用户key>
     */
    const val URL_BASE = "https://restapi.amap.com/"
    const val URL_VERSION = "v3"

    /**
     * 用户key，请求服务权限标识
     */
    const val KEY_WEB = "bcb0f2bd085fa7b89608566809e80b05"

    /**
     * 可选值：base/all
     *
     * base:返回实况天气
     *
     * all:返回预报天气
     */
    const val WEATHER_TYPE = "all"

}