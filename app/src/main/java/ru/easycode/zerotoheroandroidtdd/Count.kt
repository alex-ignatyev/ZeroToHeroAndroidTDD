package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState

    class Base(
        private val step: Int,
        private val max: Int
    ) : Count {

        init {
            if (step <= 0) {
                throw IllegalStateException("step should be positive, but was $step")
            }
            if (max <= 0) {
                throw IllegalStateException("max should be positive, but was $max")
            }
            if (step > max){
                throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val result: Int = number.toInt() + step
            val resultBase = if (result < max) {
                if ((result + step) <= max) {
                    UiState.Base(text = result.toString())
                } else {
                    UiState.Max(text = result.toString())
                }
            } else {
                UiState.Max(text = result.toString())
            }
            return resultBase
        }
    }
}