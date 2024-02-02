package com.anticbyte.newapplication.basic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anticbyte.newapplication.R
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    var painterImage by remember {
        mutableStateOf(R.drawable.ic_launcher_background)
    }



    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            modifier = modifier
                .padding(20.dp)
                .height(300.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(16.dp),
            shape = RoundedCornerShape(0),
            content = {
                Card(
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(Color.Magenta),
                    shape = RoundedCornerShape(0),
                    content = {
                        Image(
                            modifier = modifier
                                .fillMaxSize(),
                            painter = painterResource(id = painterImage),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }
                )
            }
        )

        Card(
            modifier = modifier
                .padding(30.dp)
                .wrapContentSize(align = Alignment.Center),
            shape = RoundedCornerShape(0),
            content = {
                Column(modifier.padding(vertical = 20.dp, horizontal = 15.dp)) {

                    Text(text = "Sailing Under The Bridge.")
                    Row {
                        Text(text = "Kat Kuan")
                        Text(text = "(2017")
                    }
                }
            }
        )

        Row(
            modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(modifier = modifier,
                onClick = { painterImage = R.drawable.ic_launcher_foreground }, content = {
                    Text(text = "Previous")
                })
            Button(onClick = { painterImage = R.drawable.ic_launcher_background }, content = {
                Text(text = "Next")
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePrev() {
    NewApplicationTheme {
        ArtSpace()
    }
}