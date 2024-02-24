package com.example.lottery.viewModels

import androidx.lifecycle.ViewModel
import com.example.lottery.Repository.LotteryRepository
import com.example.lottery.models.TokenResponse

class LotteryViewModel(
    private val repository: LotteryRepository = LotteryRepository()
): ViewModel() {

    private suspend fun getToken(): TokenResponse? {
        return repository.getRetrofitToken().getToken().body()
    }
}