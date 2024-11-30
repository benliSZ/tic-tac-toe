package com.benliandamit.tictactoe.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.benliandamit.tictactoe.ui.screens.AppBar
import com.benliandamit.tictactoe.ui.screens.ButtonGrid
import com.benliandamit.tictactoe.ui.screens.ResetButton
import com.benliandamit.tictactoe.ui.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { AppBar() }) { innerPadding ->
                    Surface(color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier.padding(innerPadding),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ButtonGrid(board = arrayListOf("X", "O", "X", "O", "O", "X", "", "X", "O")) {}
                            ResetButton {}
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
            ButtonGrid(board = arrayListOf("X", "O", "X", "O", "O", "X", "", "X", "O")) {}
            ResetButton {}
        }
    }
}