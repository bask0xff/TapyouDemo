package com.bask0xff.tapyoudemo.presentation.points

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bask0xff.tapyoudemo.R
import com.bask0xff.tapyoudemo.databinding.ActivityMainBinding
import com.bask0xff.tapyoudemo.databinding.ActivityPointsBinding
import com.bask0xff.tapyoudemo.domain.model.Point

class PointsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPointsBinding
    private lateinit var viewModel: PointsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, PointsViewModelFactory())[PointsViewModel::class.java]

        val points = intent.getParcelableArrayListExtra<Point>("points") ?: emptyList()
        viewModel.setPoints(points)

        val adapter = PointAdapter()
        binding.recyclerViewPoints.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPoints.adapter = adapter

        viewModel.state.observe(this) { state ->
            adapter.submitList(state.points)
        }
    }
}