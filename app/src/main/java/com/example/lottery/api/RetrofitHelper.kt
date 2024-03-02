package com.example.lottery.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val baseUrl = "https://lotteryapp.onrender.com"

    fun getInstance(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}