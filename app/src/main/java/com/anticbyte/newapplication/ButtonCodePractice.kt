package com.anticbyte.newapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme

@Composable
fun ButtonCodePractice(modifier: Modifier = Modifier) {

    var placeHolderText by remember {
        mutableStateOf("")
    }

    var pressedButtonNumber by remember {
        mutableIntStateOf(0)
    }

    placeHolderText = when (pressedButtonNumber) {
        1 -> "You Pressed Button 1"
        2 -> "You Pressed Button 2"
        3 -> "You Pressed Button 3"
        4 -> "You Pressed Button 4"
        else -> "No Button Pressed!"
    }




    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .weight(.5f)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(onClick = {
                        pressedButtonNumber = 1
                    },
                        content = { Text(text = "Button 1") })
                    Button(onClick = {
                        pressedButtonNumber = 2
                    },
                        content = { Text(text = "Button 2") })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(onClick = {
                        pressedButtonNumber = 3
                    },
                        content = { Text(text = "Button 3") })
                    Button(onClick = {
                        pressedButtonNumber = 4
                    }, content = { Text(text = "Button 4") })
                }


                Button(onClick = { pressedButtonNumber = 0 }, content = { Text(text = "Reset") })
            }
        }


        Spacer(modifier = modifier.height(10.dp))
        Box(
            modifier = modifier

                .background(MaterialTheme.colorScheme.secondaryContainer)
                .fillMaxSize()
                .weight(.5f),
            contentAlignment = Alignment.Center,
            content = { Text(text = placeHolderText) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonCodePracticePreview() {
    NewApplicationTheme {
        ButtonCodePractice()
    }
}