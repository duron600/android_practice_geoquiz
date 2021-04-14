package `fun`.yuancode.geoquiz.models

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean = false, var correct: Boolean = false) {

    fun answeredCorrectly() {
        answered = true
        correct = true
    }

    fun answeredIncorrectly() {
        answered = true
        correct = false
    }
}