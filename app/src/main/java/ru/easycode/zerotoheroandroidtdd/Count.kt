package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    data class Base(
        val step: Int,
        val max: Int,
        val min: Int
    ) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (step > max) throw IllegalStateException("max should be more than step")
            if (min > max) throw IllegalStateException("max should be more than min")

        }

        override fun initial(number: String): UiState {
            val result = number.toInt()
            return if (result == min) {
                UiState.Min(result.toString())
            } else if (result == max) {
                UiState.Max(result.toString())
            } else {
                UiState.Base(result.toString())
            }
        }

        override fun increment(number: String): UiState {
            val result = number.toInt() + step
            return if (result < max) {
                if (result + step >= max) {
                    UiState.Base(result.toString())
                } else {
                    UiState.Max(result.toString())
                }
            } else {
                UiState.Max(result.toString())
            }
        }

        override fun decrement(number: String): UiState {
            val result = number.toInt() - step
            return if (result > min) {
                if (result - step >= min) {
                    UiState.Base(result.toString())
                } else {
                    UiState.Min(result.toString())
                }
            } else {
                UiState.Min(result.toString())
            }
        }
    }
}