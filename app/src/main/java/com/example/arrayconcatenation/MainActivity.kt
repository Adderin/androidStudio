package com.example.arrayconcatenation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.arrayconcatenation.ui.theme.ArrayConcatenationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArrayConcatenationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val firstNames = arrayOf(
                        "James", "Joseph", "Art", "Len", "Don",
                        "Sima", "Mitsuo", "Leo", "Sage", "Krish",
                        "Minna", "Abe", "Kyle", "Graciela", "Cammi",
                        "Matt", "Mel", "Glady", "Yukee"
                    )

                    val lastNames = arrayOf(
                        "Bhatt", "Darakjy", "Veere", "Paprocki", "Foller",
                        "Morasca", "Toll", "Dilli", "Wiezer", "Marrier",
                        "Amigo", "Maclead", "Caldarera", "Roota", "Albares",
                        "Poquette", "Garufi", "Rim", "Whobrey"
                    )

                    val fullNames = Array(firstNames.size) { "" }

                    for (i in firstNames.indices) {
                        fullNames[i] = "${firstNames[i]} ${lastNames[i]}"
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        stickyHeader {
                            Modifier.animateItemPlacement()
                            DisplayNameText("First Names")
                        }
                        items(firstNames) { item ->
                            DisplayNameText(item)
                        }
                        stickyHeader {
                            Modifier.animateItemPlacement()
                            DisplayNameText("Last Names")
                        }
                        items(lastNames) { item ->
                            DisplayNameText(item)
                        }
                        stickyHeader {
                            Modifier.animateItemPlacement()
                            DisplayNameText("Full Names")
                        }
                        items(fullNames) { item ->
                            DisplayNameText(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayNameText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)
            .border(1.dp, Color.Gray, shape = RectangleShape)
            .padding(12.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
