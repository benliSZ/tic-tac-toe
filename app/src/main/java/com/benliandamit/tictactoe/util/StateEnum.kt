package main.util

enum class StateEnum(val value: Char) {
    TIE('T'),
    X('X'),
    O('O'),
    CONTINUE('C');

    companion object {
        fun fromValue(value: Char): Key? {
            return values().find { it.value == value }
        }
    }
}
