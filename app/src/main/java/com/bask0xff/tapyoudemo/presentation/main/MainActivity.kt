package com.bask0xff.tapyoudemo.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.bask0xff.tapyoudemo.R

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
