package com.anticbyte.newapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme
import java.text.NumberFormat

@Composable
fun TipCalculator(modifier: Modifier = Modifier) {
    var tipAmount by remember {
        mutableStateOf("")
    }
    val calculateTip = calculateTip(tipAmount.toDoubleOrNull() ?: 0.0, 15.0)
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .wrapContentSize(align = Alignment.Center)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Text(text = stringResource(id = R.string.tip_calculator))
        TipTextField(value = tipAmount, onValueChange = {tipAmount =it})
        Text(
            text = stringResource(id = R.string.tip_amount, calculateTip),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

private fun calculateTip(amount: Double, tipPercent: Double): String {
    val tip = 15.0 / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}


@Composable
fun TipTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun TipCalcPrev() {
    NewApplicationTheme(dynamicColor = false) {
        TipCalculator()
    }
}