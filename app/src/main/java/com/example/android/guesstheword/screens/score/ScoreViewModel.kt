package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {

    // Score değerinin eklenmesi için.
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    // Button gizle göster için.
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }
    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }


    init {
        _score.value = finalScore
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }


}