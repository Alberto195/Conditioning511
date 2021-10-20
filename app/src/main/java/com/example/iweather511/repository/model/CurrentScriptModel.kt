package com.example.iweather511.repository.model


import com.google.gson.annotations.SerializedName


data class CurrentScriptModel(
    @SerializedName("currentScripts")
    val currentScripts: List<CurrentScript>
) {
    data class CurrentScript(
        @SerializedName("ch_temp")
        val chTemp: Any,
        @SerializedName("co2")
        val co2: Int,
        @SerializedName("flow")
        val flow: Int,
        @SerializedName("humidity")
        val humidity: Int,
        @SerializedName("rid")
        val rid: Int,
        @SerializedName("temp")
        val temp: Int
    )
}