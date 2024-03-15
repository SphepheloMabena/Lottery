package com.example.lottery.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.lottery.viewModels.LotteryViewModel

@Composable
fun UploadPowerballResults(viewModel: LotteryViewModel) {
    var w1 by remember { mutableStateOf("") }
    var w2 by remember { mutableStateOf("") }
    var w3 by remember { mutableStateOf("") }
    var w4 by remember { mutableStateOf("") }
    var w5 by remember { mutableStateOf("") }
    var pN by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text("Winning Numbers",
            style = MaterialTheme.typography.bodyLarge)


        TextField(
            value = w1,
            onValueChange = { w1 = it },
            label = { Text("First Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = w2,
            onValueChange = { w2 = it },
            label = { Text("Second Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = w3,
            onValueChange = { w3 = it },
            label = { Text("Third Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = w4,
            onValueChange = { w4 = it },
            label = { Text("Fourth Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = w5,
            onValueChange = { w5 = it },
            label = { Text("Fifth Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )



        // TODO add date picker and sumbit button

        TextField(
            value = pN,
            onValueChange = { pN = it },
            label = { Text("Powerball Number") }
        )
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = "hellow",
        onValueChange = { text = it },
        label = { Text("Label") },
        enabled = true
    )
}