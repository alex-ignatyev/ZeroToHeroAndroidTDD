package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.UiState.ShowData
import ru.easycode.zerotoheroandroidtdd.UiState.ShowProgress

class MainViewModel(
    val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {

    fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            liveDataWrapper.update(ShowProgress)
            repository.load()
            liveDataWrapper.update(ShowData)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }
}