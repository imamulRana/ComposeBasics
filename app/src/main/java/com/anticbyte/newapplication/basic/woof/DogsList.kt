package com.anticbyte.newapplication.basic.woof

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anticbyte.newapplication.R
import com.anticbyte.newapplication.ui.theme.md_theme_light_secondaryContainer

@Composable
fun DogItem(
    modifier: Modifier = Modifier,
    @DrawableRes dogImage: Int,
    @StringRes dogName: Int,
    dogAge: Int,
    @StringRes dogHobbies: Int
) {
    Card(
        modifier = modifier
            .fillMaxWidth(), onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(containerColor = md_theme_light_secondaryContainer),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 0.dp
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(8.dp)) {
            Image(
                modifier = modifier
                    .clip(CircleShape)
                    .size(80.dp),
                painter = painterResource(id = dogImage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier.padding(start = 16.dp)) {
                Text(text = stringResource(id = dogName))
                Text(text = "$dogAge years old")
            }
        }
    }
}


@Composable
fun DogsList(dog: List<Dog>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dogs.size) {
            DogItem(
                dogImage = dog[it].imageResourceId,
                dogName = dog[it].name,
                dogAge = dog[it].age,
                dogHobbies = dog[it].hobbies
            )
        }
    }
}

@Preview
@Composable
fun DogItemPrev() {
    DogItem(
        dogImage = R.drawable.bella,
        dogName = R.string.dog_name_1,
        dogAge = 2,
        dogHobbies = R.string.dog_description_1
    )
}

@Preview(showBackground = true)
@Composable
fun DogListPrev() {
    DogsList(
        dog = dogs
    )
}