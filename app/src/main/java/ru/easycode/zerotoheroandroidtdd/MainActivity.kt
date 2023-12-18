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
        decrementButton.isEnabled = uiState !is UiState.Min
        incrementButton.isEnabled = uiState !is UiState.Max
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable()
    }
}