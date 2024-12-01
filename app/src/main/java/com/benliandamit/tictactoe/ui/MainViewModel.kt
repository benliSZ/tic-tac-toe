package com.benliandamit.tictactoe.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.benliandamit.tictactoe.util.StateEnum
import main.util.GameUtils

class MainViewModel : ViewModel() {
    var player by mutableStateOf(StateEnum.X.value)
        private set

    var state by mutableStateOf(StateEnum.CONTINUE)
        private set

    private var _board by mutableStateOf(arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    ))
    var board: Array<Array<String>>
        get() = _board
        set(value) {
            _board = value
            state = GameUtils.checkGameState(value)
        }

    fun play(row: Int, col: Int) {
        if (state != StateEnum.CONTINUE) return
        if (GameUtils.makeMove(board, player, row, col)) {
            board = board.copyOf()

            if (state == StateEnum.CONTINUE)
                player = if (player == StateEnum.X.value) StateEnum.O.value else StateEnum.X.value
        }
    }

    fun reset() {
        _board = arrayOf(
            arrayOf("", "", ""),
            arrayOf("", "", ""),
            arrayOf("", "", "")
        )
        state = StateEnum.CONTINUE
        player = StateEnum.X.value
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}