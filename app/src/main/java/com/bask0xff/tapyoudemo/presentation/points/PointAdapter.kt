package com.bask0xff.tapyoudemo.presentation.points

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bask0xff.tapyoudemo.databinding.ItemPointBinding
import com.bask0xff.tapyoudemo.domain.model.Point

class PointAdapter : ListAdapter<Point, PointViewHolder>(PointDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val binding = ItemPointBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PointViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PointViewHolder(private val binding: ItemPointBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(point: Point) {
        binding.textX.text = point.x.toString()
        binding.textY.text = point.y.toString()
    }
}

class PointDiffCallback : DiffUtil.ItemCallback<Point>() {
    override fun areItemsTheSame(oldItem: Point, newItem: Point): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Point, newItem: Point): Boolean = oldItem == newItem
}