package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private val countBase = Count.Base(2, 4)
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        if (savedInstanceState != 0){


        }

        button.setOnClickListener {
            uiState = countBase.increment(textView.text.toString())
            textView.text = uiState.text
            val buttonBlocked = uiState is UiState.Base
            button.isEnabled = buttonBlocked
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_UISTATE, uiState)

    }

    private companion object {
        const val KEY_UISTATE = "key_UiState"
    }
}