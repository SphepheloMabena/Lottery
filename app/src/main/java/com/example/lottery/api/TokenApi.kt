package com.example.lottery.api
import com.example.lottery.models.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TokenApi {
    @GET("/token")
    suspend fun getToken() : Response<TokenResponse>
}