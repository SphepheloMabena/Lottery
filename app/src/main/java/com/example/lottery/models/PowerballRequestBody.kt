package com.example.lottery.models

data class PowerballRequestBody(
    val date: String,
    val winOne: Int,
    val winTwo: Int,
    val winThree: Int,
    val winFour: Int,
    val winFive: Int,
    val powerball: Int
)
