package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var removeTextView = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(KEY)) {
                rootLayout.removeView(textView)
                removeTextView = true
            }
        }

        button.setOnClickListener {
            rootLayout.removeView(textView)
            removeTextView = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, removeTextView)
    }

    private companion object {
        const val KEY = "key"
    }
}
