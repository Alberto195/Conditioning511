package com.example.iweather511.repository

import com.example.iweather511.repository.api.ClientApi
import com.example.iweather511.repository.model.*
import java.util.*

class NetworkRepository(
    override val api: ClientApi
): INetworkRepository {

    override suspend fun getRoomConfigs(sensorId: Int): RoomConfigsModel? {
        val roomsConfigs = api.getRoomConfigs(sensorId = sensorId)
        return roomsConfigs.body()
    }

    override suspend fun getLatestSensorInfo(sensorId: Int): LatestSensorInfoModel? {
        val latestInfo = api.getLatestSensorInfo(sensorId = sensorId)
        return latestInfo.body()
    }

    override suspend fun getDailyStats(sensorId: Int, date: Date, roomId: Int): DailyStatsModel? {
        val dailyStats = api.getDailyStats(sensorId = sensorId, date = date, roomId = roomId)
        return dailyStats.body()
    }

    override suspend fun changeRoomName(sensorId: Int, roomId: Int, roomName: String) {
        api.changeRoomName(sensorId = sensorId, roomId = roomId, roomName = roomName)
    }

    override suspend fun makeNewScript(post: ScriptModel) {
        api.makeScript(post = post)
    }

    override suspend fun deleteScript(sensorId: Int, scriptId: Int) {
        api.deleteScript(sensorId = sensorId, scriptId = scriptId)
    }

    override suspend fun getAllScripts(sensorId: Int) {
        api.getAllScripts(sensorId = sensorId)
    }

    override suspend fun setScriptAsDefault(sensorId: Int, scriptId: Int) {
        api.setScriptAsDefault(sensorId = sensorId, scriptId = scriptId)
    }

    override suspend fun getCurrentSettings(sensorId: Int): CurrentScriptModel? {
        val currentScript = api.getCurrentSettings(sensorId = sensorId)
        return currentScript.body()
    }

    override suspend fun updateScript(post: ScriptModel) {
        api.updateScript(post = post)
    }

    override suspend fun getScript(sensorId: Int, scriptId: Int): ScriptModel? {
        val script = api.getScript(sensorId = sensorId, scriptId = scriptId)
        return script.body()
    }

    override suspend fun changeScriptTemperature(sensorId: Int, roomId: Int, newTemperature: Int) {
        api.changeScriptTemperature(sensorId = sensorId, roomId = roomId, newTemperature = newTemperature)
    }

    override suspend fun ventilateRoom(sensorId: Int, roomId: Int) {
        api.ventilateRoom(sensorId = sensorId, roomId = roomId)
    }
}