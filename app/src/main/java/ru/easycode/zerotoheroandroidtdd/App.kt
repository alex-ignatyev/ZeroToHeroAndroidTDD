package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    private val liveDataWrapper = LiveDataWrapper.Base()
    private val repository = Repository.Base()
    val vm = MainViewModel(liveDataWrapper, repository)
}