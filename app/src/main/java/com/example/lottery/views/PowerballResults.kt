package com.example.lottery.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.lottery.viewModels.LotteryViewModel

@Composable
fun PowerballResults(viewModel: LotteryViewModel) {
    viewModel.powerballResults.observeAsState().value?.let {
        LazyColumn() {
            items(it) { powerballItem ->
                Text(
                    text = powerballItem.date,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 8.dp
                    ),
                    style = TextStyle(color = Color.Green)
                )
                LazyRow() {
                    items(powerballItem.numbers) { number ->
                        powerballEntity(number = number)
                    }
                }
            }
        }
    }
}

@Composable
fun powerballResultItem(date: String, numbers:Array<Int>) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "2024-02-8",
            modifier = Modifier.padding(
                start = 4.dp,
                top = 8.dp
            ),
            style = TextStyle(color = Color.Green)
        )
        LazyRow() {
            items(numbers) { number ->
                powerballEntity(number = number)
            }
        }
    }
}


@Composable
fun powerballEntity(number:Int) {
    Box(Modifier.border(width = 2.dp, Color.Yellow, CircleShape)
        .width(40.dp)
    .height(40.dp)) {
        Text(text = "${number}",
            modifier = Modifier.padding(8.dp))
    }
}