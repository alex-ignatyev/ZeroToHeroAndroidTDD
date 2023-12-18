package ru.easycode.zerotoheroandroidtdd

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface UiState : Parcelable {
    val text: String

    @Parcelize
    data class Min(
        override val text: String
    ) : UiState, Parcelable

    @Parcelize
    data class Base(
        override val text: String
    ) : UiState, Parcelable

    @Parcelize
    data class Max(
        override val text: String
    ) : UiState, Parcelable
}