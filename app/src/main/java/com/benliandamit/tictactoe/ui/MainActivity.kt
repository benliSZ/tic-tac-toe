package com.benliandamit.tictactoe.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.benliandamit.tictactoe.ui.screens.AppBar
import com.benliandamit.tictactoe.ui.screens.ButtonGrid
import com.benliandamit.tictactoe.ui.screens.ResetButton
import com.benliandamit.tictactoe.ui.ui.theme.TicTacToeTheme
import com.benliandamit.tictactoe.util.StateEnum

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { AppBar() }) { innerPadding ->
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ButtonGrid(
                                board = mainViewModel.board,
                                onclick = mainViewModel::play
                            )


                            if (mainViewModel.state != StateEnum.CONTINUE) {
                                val message = when (mainViewModel.state) {
                                    StateEnum.TIE -> "It's a tie!"
                                    StateEnum.X -> "Player X wins!"
                                    StateEnum.O -> "Player O wins!"
                                    else -> ""
                                }

                                Box {
                                    Text(
                                        text = message,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            } else {
                                Text(
                                    text = "Player ${mainViewModel.player}'s turn",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                            ResetButton(onClick = mainViewModel::reset)
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicTacToeTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ButtonGrid(board = arrayOf<Array<String>>(
                arrayOf("X", "O", "X"),
                arrayOf("O", "O", "X"), arrayOf("", "X", "O")
            ), onclick = { row, col -> {} })
            ResetButton {}
        }
    }
}
