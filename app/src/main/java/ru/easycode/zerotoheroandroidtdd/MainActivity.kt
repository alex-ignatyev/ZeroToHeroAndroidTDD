package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val countBase = Count.Base(2, 4, 0)
    private var uiStateMin: UiState = UiState.Min("0")
    private var uiStateMax: UiState = UiState.Max("0")
    private var uiState: UiState? = null
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

        //decrementButton.isEnabled = uiStateMin !is UiState.Min
        //incrementButton.isEnabled = uiStateMax is UiState.Max

        incrementButton.setOnClickListener {
            uiStateMax = countBase.increment(textView.text.toString())

        }

        decrementButton.setOnClickListener {
            uiStateMin = countBase.decrement(textView.text.toString())
        }
    }
}