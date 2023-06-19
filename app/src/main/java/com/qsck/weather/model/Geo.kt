package com.qsck.weather.model

import com.google.gson.annotations.SerializedName


data class Geo(
    @SerializedName("count")
    val count: String,
    @SerializedName("geocodes")
    val geocodes: List<Geocode>,
    @SerializedName("info")
    val info: String,
    @SerializedName("infocode")
    val infocode: String,
    @SerializedName("status")
    val status: String
)

data class Geocode(
    @SerializedName("adcode")
    val adcode: String,
    @SerializedName("building")
    val building: Building,
    @SerializedName("city")
    val city: String,
    @SerializedName("citycode")
    val citycode: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("district")
    val district: List<Any>,
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("neighborhood")
    val neighborhood: Neighborhood,
    @SerializedName("number")
    val number: List<Any>,
    @SerializedName("province")
    val province: String,
    @SerializedName("street")
    val street: List<Any>,
    @SerializedName("township")
    val township: List<Any>
)

data class Building(
    @SerializedName("name")
    val name: List<Any>,
    @SerializedName("type")
    val type: List<Any>
)

data class Neighborhood(
    @SerializedName("name")
    val name: List<Any>,
    @SerializedName("type")
    val type: List<Any>
)