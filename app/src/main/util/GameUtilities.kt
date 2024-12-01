import java.util.*
import kotlin.collections.ArrayList

object GameUtils {
    const val PLAYER_X = "X"
    const val PLAYER_O = "O"

    fun makeMove(board: Array<CharArray>, player: Char, row: Int, col: Int): Boolean {
        if (row in 0..2 && col in 0..2 && board[row][col] == ' ') {
            board[row][col] = player
            return true
        }
        return false
    }

    fun checkGameState(board: Array<CharArray>): String {
        for (i in 0..2) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return "${board[i][0]} wins"
            else if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return "${board[0][i]} wins"
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return "${board[0][0]} wins"
        else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return "${board[0][2]} wins"
        else if (board.all { row -> row.all { cell -> cell != ' ' } })
            return "It's a tie"

        return "Place next move"
    }

    fun printBoard(board: Array<CharArray>) {
        for (row in board)
            println(row.joinToString(" | "))
        println()
    }
