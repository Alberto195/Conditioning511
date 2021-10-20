package com.example.iweather511.repository.model


import com.google.gson.annotations.SerializedName


data class RoomConfigsModel(
    @SerializedName("rooms")
    val rooms: List<Room>
) {
    data class Room(
        @SerializedName("r_name")
        val rName: String,
        @SerializedName("rid")
        val rid: Int
    )
}