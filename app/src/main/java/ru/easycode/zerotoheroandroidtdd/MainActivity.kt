package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var removeTextView = false
    private var enabledButton = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(TEXTVIEW_KEY)) {
                rootLayout.removeView(textView)
                removeTextView = true
            }

            val isButtonEnabled = savedInstanceState.getBoolean(BUTTON_KEY)
            button.isEnabled = isButtonEnabled
            enabledButton = isButtonEnabled
        }


        button.setOnClickListener {
            button.isEnabled = false
            enabledButton = false
            rootLayout.removeView(textView)
            removeTextView = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(TEXTVIEW_KEY, removeTextView)
        outState.putBoolean(BUTTON_KEY, enabledButton)
    }

    private companion object {
        const val TEXTVIEW_KEY = "textView_key"
        const val BUTTON_KEY = "button_key"
    }
}
