package com.example.lottery.api

import com.example.lottery.models.PowerballResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoterryApi {
    @GET("/powerball")
    suspend fun getPowerballResults(): Response<PowerballResponse>
}