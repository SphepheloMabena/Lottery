package com.example.lottery.viewModels

import android.content.ContentQueryMap
import android.content.Context
import android.widget.Toast
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lottery.Repository.LotteryRepository
import com.example.lottery.dataStore
import com.example.lottery.models.PowerballRequestBody
import com.example.lottery.models.PowerballRequestSuccess
import com.example.lottery.models.PowerballResponse
import com.example.lottery.models.Token
import com.example.lottery.models.TokenRequestBody
import com.example.lottery.models.TokenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LotteryViewModel(
    private val repository: LotteryRepository = LotteryRepository()
): ViewModel() {

    private val TOKEN_PREFERENCES = stringPreferencesKey("token")

    private val _powerballResults = MutableLiveData<PowerballResponse>()
    val powerballResults: LiveData<PowerballResponse> = _powerballResults

    fun initData() {
        viewModelScope.launch(Dispatchers.IO) {
            getToken()
        }
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            getToken()
        }
    }

    fun getPowerballResults() {
        viewModelScope.launch() {
            _powerballResults.value = getPowerballNumbers()
        }
    }

    private suspend fun getToken() {
        val token = LotteryRepository().getRetrofitToken().enqueue(
            object : Callback<TokenResponse> {
                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    //onResult(null)
                    //server is down
                    t.message

                }
                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    // val addedUser = response.body()
                    //onResult(addedUser)
                    response.message()
                    response.raw()

                    Token.tokenValue = response.body()?.access_token ?: ""
                    getPowerballResults()
                }
            }
        )
    }

     fun addPowerballNumbers(body:PowerballRequestBody, context: Context) {
        LotteryRepository().addPowerballResult(body).enqueue(
            object: Callback<PowerballRequestSuccess> {
                override fun onResponse(
                    call: Call<PowerballRequestSuccess>,
                    response: Response<PowerballRequestSuccess>
                ) {
                    Toast.makeText(context, "Results Uploaded Successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<PowerballRequestSuccess>, t: Throwable) {
                    Toast.makeText(context, "Error Uploading Results", Toast.LENGTH_LONG).show()
                }

            }
        )
    }
    private suspend fun getPowerballNumbers(): PowerballResponse? {
        return repository.getPowerballNumber()
    }


    private suspend fun updatePreference(context: Context, token: String) {

        context.dataStore.edit { settings ->
          settings[TOKEN_PREFERENCES] = token
        }
    }

    private suspend fun getTokenPref(context: Context): String {
        val flow = context.dataStore.data.map { preferences ->
            preferences[TOKEN_PREFERENCES] ?: ""
        }
        return flow.first()

    }
}