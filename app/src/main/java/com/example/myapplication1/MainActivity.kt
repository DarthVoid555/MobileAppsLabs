package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication1.data.DataSource
import com.example.myapplication1.model.Topic
import com.example.myapplication1.ui.theme.MyApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TopicGrid()
                }
            }
        }
    }
}

@Composable
fun TopicGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(all = 8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic = topic, modifier = Modifier.padding(all = 4.dp))
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.height(68.dp)) {
            // Картинка слева
            Image(
                painter = painterResource(topic.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .width(68.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            // Текст справа
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(topic.nameResId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Простая иконка "сетка" из эмодзи
                    Text(text = "\uD83D\uDD32", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicGridPreview() {
    MyApplication1Theme {
        TopicGrid()
    }
}

