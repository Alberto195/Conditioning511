package com.example.iweather511.repository.model


import com.google.gson.annotations.SerializedName


data class DailyStatsModel(
    @SerializedName("stats")
    val stats: List<Stat>
) {
    data class Stat(
        @SerializedName("co2")
        val co2: Int,
        @SerializedName("dt")
        val dt: String,
        @SerializedName("hum")
        val hum: Int,
        @SerializedName("people")
        val people: Any,
        @SerializedName("temp")
        val temp: Int,
        @SerializedName("temp_valve")
        val tempValve: Any
    )
}