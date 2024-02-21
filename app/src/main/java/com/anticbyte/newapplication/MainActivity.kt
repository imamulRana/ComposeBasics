package com.anticbyte.newapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.anticbyte.newapplication.basic.Affirmation
import com.anticbyte.newapplication.basic.AffirmationList
import com.anticbyte.newapplication.basic.DataSource
import com.anticbyte.newapplication.basic.LemonadeApp
import com.anticbyte.newapplication.ui.theme.NewApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationList(affirmation = DataSource().loadAffirmations())
                }
            }
        }
    }
}