package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val countBase = Count.Base(2, 4, 0)
    private var uiState: UiState = UiState.Min("0")
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        if (savedInstanceState != null) {
            val save = savedInstanceState.getParcelable<UiState>(KEY_UiSTATE) ?: return
            uiState = save
            textView.text = save.text
            val decrementButtonBlocked = save !is UiState.Min
            decrementButton.isEnabled = decrementButtonBlocked
            val incrementButtonBlocked = save !is UiState.Max
            incrementButton.isEnabled = incrementButtonBlocked

        }

        uiState = countBase.initial(textView.text.toString())

        checkState()

        incrementButton.setOnClickListener {
            uiState = countBase.increment(textView.text.toString())
            textView.text = uiState.text
            checkState()
        }

        decrementButton.setOnClickListener {
            uiState = countBase.decrement(textView.text.toString())
            textView.text = uiState.text
            checkState()
        }
    }

    private fun checkState() {
        val decrementButtonBlocked = uiState !is UiState.Min
        decrementButton.isEnabled = decrementButtonBlocked
        val incrementButtonBlocked = uiState !is UiState.Max
        incrementButton.isEnabled = incrementButtonBlocked
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_UiSTATE, uiState)
    }

    private companion object {
        const val KEY_UiSTATE = "key_uiState"
    }
}