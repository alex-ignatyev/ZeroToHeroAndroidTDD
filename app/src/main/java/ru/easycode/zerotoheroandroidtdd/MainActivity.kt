package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = (application as App).vm
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.actionButton)

        button.setOnClickListener {
            vm.load()
        }

        vm.liveDataWrapper.liveData().observe(this) { uiState ->
            uiState.implementationView(progressBar, textView, button)
        }
    }
}