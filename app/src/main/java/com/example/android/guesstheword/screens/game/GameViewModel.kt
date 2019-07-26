package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // Oyun bitti mi ? Bitmedi mi ?
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish



    // İşlemde ki kelime.
    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word
    // İşlemde ki puan.
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    // Değişebilir liste. Kelime Listesi.
    private lateinit var wordList: MutableList<String>


    init {

        _word.value = ""
        _score.value = 0

        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()

    }


    /** Methods for buttons presses **/
    fun onSkip() {
        if (!wordList.isEmpty()) {
            _score.value = (score.value)?.minus(1) // Güvenli bir şekilde -1 yapmak.
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            _score.value = (score.value)?.plus(1)
        }
        nextWord()
    }

    /**
     * Resets the list of words and randomizes the order
     */
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

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }else{
            onGameFinish()
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun onGameFinish() {
        _eventGameFinish.value = false
    }

}