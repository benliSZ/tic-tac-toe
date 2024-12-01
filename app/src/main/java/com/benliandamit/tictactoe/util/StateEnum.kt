package com.benliandamit.tictactoe.util

enum class StateEnum(val value: String) {
    TIE("T"),
    X("X"),
    O("O"),
    CONTINUE("C");

    companion object {
        fun fromValue(value: String): StateEnum? {
            return entries.find { it.value == value }
        }
    }
}
