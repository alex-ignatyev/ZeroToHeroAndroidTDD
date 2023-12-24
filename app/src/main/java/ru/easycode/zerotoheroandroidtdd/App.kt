package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var vm: MainViewModel

    override fun onCreate() {
        super.onCreate()
        vm = MainViewModel(liveDataWrapper = LiveDataWrapper.Base(), repository = Repository.Base())
    }
}