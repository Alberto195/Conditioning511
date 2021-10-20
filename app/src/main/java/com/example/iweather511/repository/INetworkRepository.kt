package com.example.iweather511.repository

import com.example.iweather511.repository.api.ClientApi
import com.example.iweather511.repository.model.*
import java.util.*

interface INetworkRepository {
    val api: ClientApi

    suspend fun getRoomConfigs(sensorId: Int): RoomConfigsModel?

    suspend fun getLatestSensorInfo(sensorId: Int): LatestSensorInfoModel?

    suspend fun getDailyStats(sensorId: Int, date: Date, roomId: Int): DailyStatsModel?

    suspend fun changeRoomName(sensorId: Int, roomId: Int, roomName: String)

    suspend fun makeNewScript(post: ScriptModel)

    suspend fun deleteScript(sensorId: Int, scriptId: Int)

    suspend fun getAllScripts(sensorId: Int) // TODO return

    suspend fun setScriptAsDefault(sensorId: Int, scriptId: Int)

    suspend fun getCurrentSettings(sensorId: Int): CurrentScriptModel?

    suspend fun updateScript(post: ScriptModel)

    suspend fun getScript(sensorId: Int, scriptId: Int): ScriptModel?

    suspend fun changeScriptTemperature(sensorId: Int, roomId: Int, newTemperature: Int)

    suspend fun ventilateRoom(sensorId: Int, roomId: Int)
}