package ru.easycode.zerotoheroandroidtdd

interface BundleWrapper {

    interface Save: BundleWrapper {
        fun save(uiState: UiState)
    }

    interface Restore: BundleWrapper {
        fun restore(): UiState
    }

    interface Mutable: Save, Restore {

        class Base(): Mutable {

            private var uiState: UiState? = null

            override fun save(uiState: UiState) {
                this.uiState = uiState
            }

            override fun restore(): UiState {
                return uiState!!
            }
        }
    }
}