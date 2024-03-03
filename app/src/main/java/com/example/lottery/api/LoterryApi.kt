package com.example.lottery.api

import com.example.lottery.models.PowerballRequestBody
import com.example.lottery.models.PowerballRequestSuccess
import com.example.lottery.models.PowerballResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoterryApi {
    @GET("/powerball")
    suspend fun getPowerballResults(): Response<PowerballResponse>

    @POST("/add_powerball")
    fun addPowerballResult(@Body body: PowerballRequestBody): Call<PowerballRequestSuccess>
}