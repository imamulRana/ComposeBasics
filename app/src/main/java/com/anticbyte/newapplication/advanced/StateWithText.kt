package com.anticbyte.newapplication.advanced

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StateWithText(modifier: Modifier = Modifier) {
    val state = rememberTextFieldState()

    BasicTextField2(
        modifier = modifier
            .height(50.dp)
            .background(Color.LightGray)
            .fillMaxWidth(), state = state,
        cursorBrush = Brush.verticalGradient(colors = listOf(Color.Green, Color.Blue))
    )
}

@Composable
fun NestedColumn(modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state)
    ) {
        Row(
            modifier
                .height(intrinsicSize = IntrinsicSize.Min)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Hello")
            VerticalDivider()
            Text(text = "World")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefPrevNew() {
    NestedColumn()
}