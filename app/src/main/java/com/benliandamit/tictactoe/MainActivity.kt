package com.benliandamit.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benliandamit.tictactoe.util.StateEnum
import main.util.GameUtils

class MainActivity : AppCompatActivity() {
    private lateinit var board: Array<Array<Button>>
    private lateinit var playerTurnTextView: TextView
    private lateinit var resetButton: Button
    private var player = StateEnum.X.value
    private var state = StateEnum.CONTINUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        playerTurnTextView = findViewById(R.id.playerTurn)
        resetButton = findViewById(R.id.resetButton)
        board = arrayOf(
            arrayOf(findViewById(R.id.button00), findViewById(R.id.button01), findViewById(R.id.button02)),
            arrayOf(findViewById(R.id.button10), findViewById(R.id.button11), findViewById(R.id.button12)),
            arrayOf(findViewById(R.id.button20), findViewById(R.id.button21), findViewById(R.id.button22))
        )

        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, button ->
                button.setOnClickListener { play(rowIndex, colIndex) }
            }
        }

        resetButton.setOnClickListener { reset() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun play(row: Int, col: Int) {
        if (state != StateEnum.CONTINUE) return
        if (GameUtils.makeMove(board.map { it.map { button -> button.text.toString() }.toTypedArray() }.toTypedArray(), player, row, col)) {
            board[row][col].text = player
            state = GameUtils.checkGameState(board.map { it.map { button -> button.text.toString() }.toTypedArray() }.toTypedArray())

            if (state == StateEnum.CONTINUE) {
                player = if (player == StateEnum.X.value) StateEnum.O.value else StateEnum.X.value
                playerTurnTextView.text = "Player $player's turn"
            } else {
                playerTurnTextView.text = when (state) {
                    StateEnum.TIE -> "It's a tie!"
                    StateEnum.X -> "Player X wins!"
                    StateEnum.O -> "Player O wins!"
                    else -> ""
                }
            }
        }
    }

    private fun reset() {
        board.forEach { row ->
            row.forEach { button ->
                button.text = ""
            }
        }
        state = StateEnum.CONTINUE
        player = StateEnum.X.value
        playerTurnTextView.text = "Player $player's turn"
    }
}