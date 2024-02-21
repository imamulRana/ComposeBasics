package com.anticbyte.newapplication.basic

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anticbyte.newapplication.R


data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class DataSource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5)
        )
    }
}


@Composable
fun AffirmationCard(modifier: Modifier = Modifier, affirmation: Affirmation) {
    Card(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 194.dp),
            painter = painterResource(id = affirmation.imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = modifier.padding(8.dp),
            text = stringResource(id = affirmation.stringResourceId),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun AffirmationList(
    modifier: Modifier = Modifier,
    affirmation: List<Affirmation>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
        items(affirmation.size) {
            AffirmationCard(affirmation = affirmation[it])
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AffirmationCardPrev() {

}


data class Flower(
    val name: String,
    val price: Int
)

fun main() {
    val flower: Flower = Flower(name = "Rose", price = 20)
    val name: String = "Rafi"
    println(flower.name)
}


@Preview(showBackground = true)
@Composable
fun HelloWorldList() {
    val names: List<String> = listOf("Rafi", "Rana", "Kawser", "Afredi", "Hasan", "Khan", "Rifat")

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(names.size) {
            Text(
                text = names[it],
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.paddingFromBaseline(top = 48.dp)
            )
        }
    }
}




