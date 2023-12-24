package ru.easycode.zerotoheroandroidtdd

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle

interface BundleWrapper {

    interface Save : BundleWrapper {
        fun save(uiState: UiState)
    }

    interface Restore : BundleWrapper {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore {

        class Base(private val bundle: Bundle) : Mutable {

            override fun save(uiState: UiState) {
                bundle.putParcelable(KEY, uiState)
            }

            override fun restore(): UiState {
                return if (VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable(KEY, UiState::class.java) as UiState
                } else {
                    (bundle.getParcelable(KEY) as? UiState)!!
                }
            }

            companion object {
                private const val KEY = "uiStateKey"
            }
        }
    }
}