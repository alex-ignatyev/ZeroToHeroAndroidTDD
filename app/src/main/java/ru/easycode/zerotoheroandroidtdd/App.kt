package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {
    private var liveDataWrapper = LiveDataWrapper.Base()
    private val repository = Repository.Base()
    val vm = MainViewModel(liveDataWrapper, repository)
    val bundle = BundleWrapper.Mutable.Base()
}