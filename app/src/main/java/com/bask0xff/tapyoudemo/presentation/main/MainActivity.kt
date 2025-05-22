package com.bask0xff.tapyoudemo.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.bask0xff.tapyoudemo.R
import com.bask0xff.tapyoudemo.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}
