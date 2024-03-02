package com.example.lottery.Repository

import com.example.lottery.api.LoterryApi
import com.example.lottery.api.RetrofitHelper
import com.example.lottery.api.RetrofitTokenHelper
import com.example.lottery.api.TokenApi
import com.example.lottery.models.PowerballResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.create

class LotteryRepository {

     fun getRetrofitToken(): TokenApi {
        return RetrofitTokenHelper.getInstance().create(TokenApi::class.java)
    }
    suspend fun getPowerballNumber(): LoterryApi {
        return RetrofitHelper.getInstance().create(LoterryApi::class.java)
    }

}