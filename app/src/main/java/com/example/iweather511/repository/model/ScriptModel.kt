package com.example.iweather511.repository.model


import com.google.gson.annotations.SerializedName


data class ScriptModel(
    @SerializedName("did")
    val did: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("roomGroup")
    val roomGroup: RoomGroup
) {
    data class RoomGroup(
        @SerializedName("dayGroups")
        val dayGroups: List<DayGroups>,
        @SerializedName("rIDs")
        val rIDs: List<Int>
    ) {
        data class DayGroups(
            @SerializedName("days")
            val days: List<Int>,
            @SerializedName("settings")
            val settings: List<Settings>,
        ) {
            data class Settings(
                @SerializedName("at_home")
                val atHome: Int,
                @SerializedName("co2")
                val co2: Int,
                @SerializedName("dont_use")
                val dontUse: List<Any>,
                @SerializedName("hum")
                val hum: Int,
                @SerializedName("must_use")
                val mustUse: List<Any>,
                @SerializedName("mute")
                val mute: Int,
                @SerializedName("temp")
                val temp: Int,
                @SerializedName("time")
                val time: String
            )
        }
    }
}
