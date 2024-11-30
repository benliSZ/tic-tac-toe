package com.benliandamit.tictactoe.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benliandamit.tictactoe.ui.ui.theme.PurpleGrey40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Tic Tac Toe") }
    )
}

@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(16.dp).height(50.dp)) {
        Text(
            text = "Restart",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ButtonGrid(board: ArrayList<String>, onclick: (Int) -> Unit) {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            TicTacToeButton(text = board[0]) { onclick(0) }
            TicTacToeButton(text = board[1]) { onclick(1) }
            TicTacToeButton(text = board[2]) { onclick(2) }
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            TicTacToeButton(text = board[3]) { onclick(3) }
            TicTacToeButton(text = board[4]) { onclick(4) }
            TicTacToeButton(text = board[5]) { onclick(5) }
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            TicTacToeButton(text = board[6]) { onclick(6) }
            TicTacToeButton(text = board[7]) { onclick(7) }
            TicTacToeButton(text = board[8]) { onclick(8) }
        }
    }
}

@Composable
fun TicTacToeButton(text: String, onclick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        TextButton(
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, PurpleGrey40),
            onClick = onclick,
            enabled = text.isBlank()
        ) {
            Text(
                text = text,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp
                ),
                modifier = Modifier.padding(16.dp).size(40.dp).fillMaxHeight()
            )
        }
    }
}