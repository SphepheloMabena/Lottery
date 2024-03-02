package com.example.lottery.api

import com.example.lottery.models.TokenRequestBody
import com.example.lottery.models.TokenResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface TokenApi {

// we need to change the body type

    @Multipart
    @POST("token") // Assuming "token" is the endpoint path
    fun getToken(
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody
    ): Call<TokenResponse>

}