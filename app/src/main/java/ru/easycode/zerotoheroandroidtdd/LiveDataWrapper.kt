package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base() : LiveDataWrapper {

        override fun update(value: UiState) {
            TODO("Not yet implemented")
        }

        override fun liveData(): LiveData<UiState> {
            TODO("Not yet implemented")
        }
    }
}