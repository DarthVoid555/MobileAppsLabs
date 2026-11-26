package com.example.myapplication1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication1.R

@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        GameLayout(
            currentScrambledWord = gameUiState.currentScrambledWord,
            userGuess = gameViewModel.userGuess,
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            isGuessWrong = gameUiState.isGuessedWordWrong,
            wordCount = gameUiState.currentWordCount,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GameStatus(score = gameUiState.score, modifier = Modifier.padding(8.dp))
            Button(
                onClick = { gameViewModel.checkUserGuess() },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) {
                Text(stringResource(R.string.submit))
            }
            OutlinedButton(
                onClick = { gameViewModel.skipWord() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.skip))
            }
        }
    }

    if (gameUiState.isGameOver) {
        FinalScoreDialog(
            score = gameUiState.score,
            onPlayAgain = { gameViewModel.resetGame() }
        )
    }
}

@Composable
fun GameLayout(
    currentScrambledWord: String,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    isGuessWrong: Boolean,
    wordCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(R.string.word_count, wordCount),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(16.dp)
            )
        }

        Text(
            text = currentScrambledWord,
            fontSize = 45.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = userGuess,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onUserGuessChanged,
            label = {
                if (isGuessWrong) {
                    Text(stringResource(R.string.wrong_guess))
                } else {
                    Text(stringResource(R.string.enter_your_word))
                }
            },
            isError = isGuessWrong,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { onKeyboardDone() })
        )
    }
}

@Composable
fun GameStatus(score: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.score, score),
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(stringResource(R.string.congratulations)) },
        text = { Text(stringResource(R.string.you_scored, score)) },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(stringResource(R.string.play_again))
            }
        },
        dismissButton = {
            TextButton(onClick = { /* Тут можно добавить finish() для Activity, если нужно закрывать приложение */ }) {
                Text(stringResource(R.string.exit))
            }
        }
    )
}