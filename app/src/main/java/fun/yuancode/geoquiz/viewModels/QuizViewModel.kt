package `fun`.yuancode.geoquiz.viewModels

import `fun`.yuancode.geoquiz.R
import `fun`.yuancode.geoquiz.models.Question
import android.util.Log
import androidx.lifecycle.ViewModel


class QuizViewModel(): ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    var currentIndex = 0
    var isCheater = false

    val currentQuestion: Question
        get() = questionBank[currentIndex]

    init {
        Log.d("GEOQUIZ", "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GEOQUIZ", "ViewModel instance about to be destroyed")
    }

    fun movePrevious() {
        if (currentIndex <= 0) {
            currentIndex = questionBank.size - 1
        } else {
            currentIndex -= 1
        }
    }

    fun moveNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun score(): Double {
        return (questionBank.count { it.correct } / questionBank.count().toDouble()) * 100
    }

    fun checkAnswer(answer: Boolean): Boolean {
        val correct = currentQuestion.answer == answer
        if (correct) {
            currentQuestion.answeredCorrectly()
        } else {
            currentQuestion.answeredIncorrectly()
        }
        return correct
    }
}