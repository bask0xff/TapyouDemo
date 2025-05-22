package com.bask0xff.tapyoudemo.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.bask0xff.tapyoudemo.R
import com.bask0xff.tapyoudemo.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: binding: $binding")

        viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]

        binding.buttonGo.setOnClickListener {
            Log.d(TAG, "onCreate: onclick...")
            val count = binding.editTextCount.text.toString().toIntOrNull() ?: 0
            Log.d(TAG, "onCreate: onclick => $count")
            viewModel.fetchPoints(count)
        }

        viewModel.state.observe(this) { state ->
            when {
                state.isLoading -> showLoading()
                state.error != null -> showError(state.error)
                state.points.isNotEmpty() -> {
                    Log.d(TAG, "onCreate: show points activity...")
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        binding.progressBar.visibility = View.GONE
        Log.e(TAG, "showError: $message", )
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
