package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button)

    object ShowProgress : UiState {

        override fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = false
            progressBar.isVisible = true
            textView.isVisible = false
        }
    }

    object ShowData : UiState {

        override fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isVisible = true
        }
    }
}