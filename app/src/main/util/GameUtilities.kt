import java.util.*
import kotlin.collections.ArrayList

object GameUtils {
    const val PLAYER_X = "X"
    const val PLAYER_O = "O"

    fun makeMove(board: Array<CharArray>, player: Char, row: Int, col: Int): Boolean {
        // Check if the move is valid (within bounds and on an empty cell)
        if (row in 0..2 && col in 0..2 && board[row][col] == ' ') {
            board[row][col] = player // Place the player's symbol on the board
            return true
        }
        return false // Invalid move
    }

    // Utility function to print the board
    fun printBoard(board: Array<CharArray>) {
        for (row in board) {
            println(row.joinToString(" | "))
        }
        println()
    }

    // Example usage
    fun main() {
        // Initialize a 3x3 board with empty spaces
        val board = Array(3) { CharArray(3) { ' ' } }

        // Example moves
        if (makeMove(board, 'X', 0, 0)) {
            println("Move made!")
        } else {
            println("Invalid move!")
        }

        printBoard(board)

        if (makeMove(board, 'O', 1, 1)) {
            println("Move made!")
        } else {
            println("Invalid move!")
        }

        printBoard(board)

        // Try an invalid move (cell already occupied)
        if (makeMove(board, 'X', 1, 1)) {
            println("Move made!")
        } else {
            println("Invalid move!")
        }

        printBoard(board)
    }



    fun checkGameState(board: Array<CharArray>): String {
        // Check rows and columns for a win
        for (i in 0..2) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return "${board[i][0]} wins" // Row win
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return "${board[0][i]} wins" // Column win
            }
        }

        // Check diagonals for a win
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return "${board[0][0]} wins" // Main diagonal
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return "${board[0][2]} wins" // Anti-diagonal
        }

        // Check for a tie (no empty spaces and no winner)
        if (board.all { row -> row.all { cell -> cell != ' ' } }) {
            return "It's a tie"
        }

        // The game is still ongoing
        return "Game ongoing"
    }

    // Example usage
    fun main() {
        val board = arrayOf(
            charArrayOf('X', 'O', 'X'),
            charArrayOf('X', 'O', 'O'),
            charArrayOf('O', 'X', 'X')
        )

        println(checkGameState(board)) // Example: It's a tie

        val board2 = arrayOf(
            charArrayOf('X', 'X', 'X'),
            charArrayOf('O', 'O', ' '),
            charArrayOf(' ', ' ', ' ')
        )

        println(checkGameState(board2)) // Example: X wins
    }
