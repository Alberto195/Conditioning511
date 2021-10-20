package com.example.iweather511.repository.api

import com.example.iweather511.repository.model.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*

interface ClientApi {

    @GET("app/rm_config")
    suspend fun getRoomConfigs(
        @Query("did") sensorId: Int
    ): Response<RoomConfigsModel>

    @GET("app/datchik")
    suspend fun getLatestSensorInfo(
        @Query("did") sensorId: Int
    ): Response<LatestSensorInfoModel>

    @GET("app/stat")
    suspend fun getDailyStats(
        @Query("did") sensorId: Int,
        @Query("dt") date: Date,
        @Query("rid") roomId: Int
    ): Response<DailyStatsModel>

    @GET("app/room_name")
    suspend fun changeRoomName(
        @Query("did") sensorId: Int,
        @Query("rid") roomId: Int,
        @Query("rname") roomName: String
    )

    @POST("app/script")
    suspend fun makeScript(
        @Body post: ScriptModel
    )

    @GET("app/del_script")
    suspend fun deleteScript(
        @Query("did") sensorId: Int,
        @Query("sc_id") scriptId: Int,
    )

    @GET("app/get_scripts") // TODO Созвон с Даней
    suspend fun getAllScripts(
        @Query("did") sensorId: Int,
    )

    @GET("app/set_script")
    suspend fun setScriptAsDefault(
        @Query("did") sensorId: Int,
        @Query("sc_id") scriptId: Int,
    )

    @GET("app/script_cur")
    suspend fun getCurrentSettings(
        @Query("did") sensorId: Int,
    ): Response<CurrentScriptModel>

    @PUT("app/update_script")
    suspend fun updateScript(
        @Body post: ScriptModel
    )

    @GET("dev/script")
    suspend fun getScript(
        @Query("did") sensorId: Int,
        @Query("sc_id") scriptId: Int,
    ): Response<ScriptModel> // TODO вроде это возвращает

    @GET("app/ch_temp")
    suspend fun changeScriptTemperature(
        @Query("did") sensorId: Int,
        @Query("rid") roomId: Int,
        @Query("ch_temp") newTemperature: Int
    )

    @GET("app/flow")
    suspend fun ventilateRoom(
        @Query("did") sensorId: Int,
        @Query("rid") roomId: Int,
    )

    companion object {
        operator fun invoke(): ClientApi {
            return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(ClientApi::class.java)
        }
        private const val BASE_URL = "https://back.vc-app.ru/"
    }
}