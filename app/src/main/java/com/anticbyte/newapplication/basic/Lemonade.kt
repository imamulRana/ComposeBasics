package com.anticbyte.newapplication.basic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anticbyte.newapplication.R
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentImage by remember {
        mutableIntStateOf(R.drawable.lemon_tree)
    }
    var currentText by remember {
        mutableStateOf("Tap the lemon tree to select a lemon")
    }

    var currentValue by remember {
        mutableIntStateOf(0)
    }

    val imageAndTextByValue = when (currentValue) {
        0 -> currentImage = R.drawable.lemon_tree

        1 -> currentImage = R.drawable.lemon_squeeze
        else -> {}
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .height(80.dp),
            contentAlignment = Alignment.Center,
            content = { Text(text = "Lemonade") }
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp), onClick = {
                currentValue += 1
            }, content = {
                Image(
                    modifier = modifier
                        .padding(50.dp)
                        .fillMaxSize(),
                    painter = painterResource(id = currentImage),
                    contentDescription = ""
                )

            })
            Text(text = currentText)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    NewApplicationTheme {
        LemonadeApp()
    }
}