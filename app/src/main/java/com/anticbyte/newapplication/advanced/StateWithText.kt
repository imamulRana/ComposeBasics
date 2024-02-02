package com.anticbyte.newapplication.advanced

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun StateWithText() {
    var value by remember {
        mutableStateOf("")
    }

    OutlinedTextField(value = value, onValueChange = { value = it })
}