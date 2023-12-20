package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.UiState.ShowData
import ru.easycode.zerotoheroandroidtdd.UiState.ShowProgress

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var button: Button
    private val repository = Repository.Base()
    private val liveDataWrapper = LiveDataWrapper.Base()
    private val vm = MainViewModel(liveDataWrapper, repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.actionButton)

        liveDataWrapper.liveData().observe(this) { uiState ->
            progressBar.isVisible = uiState is ShowProgress
            button.isEnabled = uiState !is ShowProgress
            textView.isVisible = uiState is ShowData
        }

        button.setOnClickListener {
            vm.load()
        }
    }
}