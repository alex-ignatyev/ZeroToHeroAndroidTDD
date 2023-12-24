package ru.easycode.zerotoheroandroidtdd

import android.os.Parcelable
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.parcelize.Parcelize

interface UiState : Parcelable {

    fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button)

    @Parcelize
    object ShowProgress : UiState {
        override fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = false
            progressBar.isVisible = true
            textView.isVisible = false
        }

    }

    @Parcelize
    object ShowData : UiState {
        override fun implementationView(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isVisible = true
        }

    }
}