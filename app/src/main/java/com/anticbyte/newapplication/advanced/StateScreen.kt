package com.anticbyte.newapplication.advanced

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StateScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {

        Text(text = "Hello \nThis Is A text")

        StateWithText()
        StateWithText()
        StateWithText()

    }
}

@Preview(showBackground = true)
@Composable
fun DefPrev() {
    StateScreen()
}