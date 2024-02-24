package com.example.lottery.Repository

import com.example.lottery.api.RetrofitTokenHelper
import com.example.lottery.api.TokenApi

class LotteryRepository {

    suspend fun getRetrofitToken(): TokenApi {
        return RetrofitTokenHelper.getInstance().create(TokenApi::class.java)
    }

}