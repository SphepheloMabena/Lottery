package com.example.lottery.api

import com.example.lottery.Repository.LotteryRepository
import com.example.lottery.models.Token
import com.example.lottery.models.TokenRequestBody
import com.example.lottery.models.TokenResponse
import okhttp3.Interceptor
import okhttp3.Response

import retrofit2.Call
import retrofit2.Callback

import retrofit2.Retrofit


class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = Token.tokenValue
        val newRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        // Retry the request with the new access token
        return chain.proceed(newRequest)


    }
}