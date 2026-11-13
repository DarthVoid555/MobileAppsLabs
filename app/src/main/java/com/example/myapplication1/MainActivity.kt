package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication1.ui.theme.MyApplication1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Картинка
        Image(
            painter = painterResource(id = when (currentIndex) {
                1 -> R.drawable.image1
                2 -> R.drawable.image2
                else -> R.drawable.image3
            }),
            contentDescription = null,
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        // Подпись
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(
                    when (currentIndex) {
                        1 -> R.string.artwork_title_1
                        2 -> R.string.artwork_title_2
                        else -> R.string.artwork_title_3
                    }
                ),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(
                    when (currentIndex) {
                        1 -> R.string.artwork_artist_1
                        2 -> R.string.artwork_artist_2
                        else -> R.string.artwork_artist_3
                    }
                ),
                fontSize = 16.sp
            )
        }


        // Кнопки
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { if (currentIndex > 1) currentIndex-- },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(stringResource(R.string.previous))
            }
            Button(
                onClick = { if (currentIndex < 3) currentIndex++ },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    MyApplication1Theme {
        ArtSpaceApp()
    }
}