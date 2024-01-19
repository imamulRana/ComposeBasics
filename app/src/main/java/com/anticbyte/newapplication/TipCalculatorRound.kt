package com.anticbyte.newapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme
import java.text.NumberFormat

@Composable
fun CalculateTheTipTap(modifier: Modifier = Modifier) {
    var amountTip by remember {
        mutableStateOf("")
    }
    var tipPercent by remember {
        mutableStateOf("")
    }
    var round by remember {
        mutableStateOf(false)
    }


    val totalAmount = totalM(amountTip.toDoubleOrNull() ?: 0.0, tipPercent.toDoubleOrNull() ?: 0.0)
    val calculate = amountTip.toDoubleOrNull() ?: 0.0
    val toPercent = tipPercent.toDoubleOrNull() ?: 0.0
    val tip = calculate1(calculate, toPercent, round)

    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .wrapContentSize(align = Alignment.Center)
            .verticalScroll(rememberScrollState())
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.calculate_tip), fontSize = 30.sp)
        TextField(value = amountTip, onValueChange = { amountTip = it })
        TextField2(value = tipPercent, onValueChange = { tipPercent = it })
        RoundUpFunction(round = round, onRound = { round = it })
        Text(text = stringResource(id = R.string.tip_amount, tip), fontSize = 30.sp)
        Text(text = stringResource(id = R.string.total_amount, totalAmount), fontSize = 30.sp)
    }
}

@Composable
fun TextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun TextField2(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        label = { Text(text = "Tip Percent") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun RoundUpFunction(round: Boolean, onRound: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Round Up Tip", fontSize = 30.sp)
        Spacer(modifier = Modifier.width(30.dp))
        Switch(checked = round, onCheckedChange = onRound)
    }
}

private fun totalM(amount: Double, percent: Double): String {
    val total = amount + percent
    return NumberFormat.getCurrencyInstance().format(total)
}

private fun calculate1(amount: Double, percent: Double = 15.0, round: Boolean): String {
    val tops = percent / 100 * amount
    if (round) {
        kotlin.math.ceil(tops)
    }
    return NumberFormat.getCurrencyInstance().format(tops)
}

@Preview(showBackground = true)
@Composable
fun TipTapFunction() {
    NewApplicationTheme {

        CalculateTheTipTap()
    }
}