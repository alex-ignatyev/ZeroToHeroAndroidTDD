package ru.easycode.zerotoheroandroidtdd

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface UiState: Parcelable {

    @Parcelize
    data class Min(
        val text: String
    ): Parcelable, UiState

    @Parcelize
    data class Base(
        val text: String
    ): Parcelable, UiState

    @Parcelize
    data class Max(
        val text: String
    ): Parcelable, UiState
}