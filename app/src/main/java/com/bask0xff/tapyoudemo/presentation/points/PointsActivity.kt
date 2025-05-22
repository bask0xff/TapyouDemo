package com.bask0xff.tapyoudemo.presentation.points

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bask0xff.tapyoudemo.databinding.ActivityPointsBinding
import com.bask0xff.tapyoudemo.domain.model.Point
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class PointsActivity : ComponentActivity() {
    private lateinit var binding: ActivityPointsBinding
    private val viewModel: PointsViewModel by viewModels { PointsViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("PointsActivity", "onCreate: Activity started")

        val points = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("points", Point::class.java) ?: emptyList()
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableArrayListExtra<Point>("points") ?: emptyList()
        }
        Log.d("PointsActivity", "Received points: ${points.size}")

        viewModel.setPoints(points)

        val adapter = PointAdapter()
        binding.recyclerViewPoints.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPoints.adapter = adapter

        setupLineChart(points)

        viewModel.state.observe(this) { state ->
            adapter.submitList(state.points)
            setupLineChart(state.points)
        }
    }

    private fun setupLineChart(points: List<Point>) {
        if (points.isEmpty()) {
            binding.lineChart.visibility = View.GONE
            return
        }
        binding.lineChart.visibility = View.VISIBLE

        val sortedPoints = points.sortedBy { it.x }

        val entries = sortedPoints.map { Entry(it.x.toFloat(), it.y.toFloat()) }

        val dataSet = LineDataSet(entries, "Points")
        dataSet.color = android.graphics.Color.BLUE
        dataSet.setCircleColor(android.graphics.Color.RED)
        dataSet.lineWidth = 2f
        dataSet.circleRadius = 4f
        dataSet.setDrawValues(false)

        val lineData = LineData(dataSet)

        binding.lineChart.apply {
            data = lineData
            description.isEnabled = false
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                setDrawLabels(true)
                labelCount = sortedPoints.size.coerceAtMost(10)
            }

            axisLeft.setDrawGridLines(true)
            axisRight.isEnabled = false

            invalidate()
        }
    }
}