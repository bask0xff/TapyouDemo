package com.bask0xff.tapyoudemo.presentation.points

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bask0xff.tapyoudemo.R
import com.bask0xff.tapyoudemo.databinding.ActivityMainBinding
import com.bask0xff.tapyoudemo.databinding.ActivityPointsBinding

class PointsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPointsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}