package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {


    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private lateinit var wordList: MutableList<String>


    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()

    }



    fun onSkip() {
        if (!wordList.isEmpty()) {
            _score.value = (score.value)?.minus(1)
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            _score.value = (score.value)?.plus(1)
        }
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            _word.value = wordList.removeAt(0)
        } else {
            onGameFinish()
        }
    }


    override fun onCleared() {
        super.onCleared()
    }

    fun onGameFinish() {
        _eventGameFinish.value = false
    }

}