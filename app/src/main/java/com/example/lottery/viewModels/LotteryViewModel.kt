package com.example.lottery.viewModels

import android.content.ContentQueryMap
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lottery.Repository.LotteryRepository
import com.example.lottery.dataStore
import com.example.lottery.models.TokenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class LotteryViewModel(
    private val repository: LotteryRepository = LotteryRepository()
): ViewModel() {

    private val TOKEN_PREFERENCES = stringPreferencesKey("token")

    fun initData(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            getToken(context)?.access_token?.let { updatePreference(context, it) }
        }
    }

    private suspend fun getToken(context: Context): TokenResponse? {
        return repository.getRetrofitToken().getToken().body()
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