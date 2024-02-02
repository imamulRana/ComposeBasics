package com.anticbyte.newapplication.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

enum class Difficulty {
    Easy, Medium, Hard
}

data class FillTheBlank<T>(
    val questionText: String,
    val questionAnswer: T,
    val questionDifficulty: Difficulty
)


data class Flower(
    val flowerName: String,
    val flowerPrice: Int,
    val flowerColor: String
)


fun main() {
    val stringQuestion = FillTheBlank(questionText = "What's Your name?", 2, Difficulty.Easy)
    println(stringQuestion)

    val rose = Flower("Rose", 40, "Red")

    println(rose)
}


@Composable
fun TextFieldSample() {
    var textValues by remember {
        mutableStateOf("")
    }
    val isEnabled: (Boolean) -> Boolean = { it }
    var checkedState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = !checkedState },
            enabled = isEnabled(textValues.isEmpty())
        )
        OutlinedTextField(
            value = textValues,
            onValueChange = { textValues = it },
            enabled = isEnabled(!checkedState)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Sample() {
    TextFieldSample()

}