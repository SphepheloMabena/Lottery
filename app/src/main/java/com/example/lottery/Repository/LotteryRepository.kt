package com.example.lottery.Repository

import com.example.lottery.api.LoterryApi
import com.example.lottery.api.RetrofitHelper
import com.example.lottery.api.RetrofitTokenHelper
import com.example.lottery.api.TokenApi
import com.example.lottery.models.PowerballRequestBody
import com.example.lottery.models.PowerballRequestSuccess
import com.example.lottery.models.PowerballResponse
import com.example.lottery.models.TokenResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.create

class LotteryRepository {
    private val helper = RetrofitHelper.getInstance().create(LoterryApi::class.java)

     fun getRetrofitToken(): Call<TokenResponse> {
         val usernameRequestBody = RequestBody.create(MultipartBody.FORM, "admin")
         val passwordRequestBody = RequestBody.create(MultipartBody.FORM, "2024Init")
        return RetrofitTokenHelper.getInstance().create(TokenApi::class.java).getToken(
            username = usernameRequestBody,
            password = passwordRequestBody
        )
    }
    suspend fun getPowerballNumber(): PowerballResponse? {
        return helper.getPowerballResults().body()
    }
    fun addPowerballResult(results: PowerballRequestBody): Call<PowerballRequestSuccess> {
        return helper.addPowerballResult(results)
    }

}