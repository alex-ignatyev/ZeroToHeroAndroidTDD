package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base() : LiveDataWrapper {

        override fun update(value: UiState) {

        }

        override fun liveData(): LiveData<UiState> {

        }
    }
}