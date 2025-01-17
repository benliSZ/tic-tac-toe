package main.util

import com.benliandamit.tictactoe.util.StateEnum

object GameUtils {

    fun makeMove(board: Array<Array<String>>, player: String, row: Int, col: Int): Boolean {
        if (row in 0..2 && col in 0..2 && board[row][col] == "") {
            board[row][col] = player
            return true
        }
        return false
    }

    fun checkGameState(board: Array<Array<String>>): StateEnum {
        for (i in 0..2) {
            if (board[i][0] != "" && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                StateEnum.fromValue(board[i][0])?.let { return it }
            } else if (board[0][i] != "" && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                StateEnum.fromValue(board[0][i])?.let { return it }
            }
        }

        if (board[0][0] != "" && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            StateEnum.fromValue(board[0][0])?.let { return it }
        } else if (board[0][2] != "" && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            StateEnum.fromValue(board[0][2])?.let { return it }
        } else if (board.all { row -> row.all { cell -> cell != "" } }) {
            return StateEnum.TIE
        }
        return StateEnum.CONTINUE
    }
}
