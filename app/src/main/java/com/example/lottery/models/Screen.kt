package com.example.lottery.models

import androidx.annotation.StringRes
import com.example.lottery.R

sealed class Screen(val route: String) {
    object Results : Screen("results")
    object Upload : Screen("upload")
}