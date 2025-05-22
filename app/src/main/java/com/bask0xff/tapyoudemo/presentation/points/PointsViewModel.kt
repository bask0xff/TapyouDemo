package com.bask0xff.tapyoudemo.presentation.points

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bask0xff.tapyoudemo.domain.model.Point

class PointsViewModel : ViewModel() {
    private val _state = MutableLiveData<PointsScreenState>()
    val state: LiveData<PointsScreenState> get() = _state

    fun setPoints(points: List<Point>) {
        _state.value = PointsScreenState(points.sortedBy { it.x })
    }
}

data class PointsScreenState(val points: List<Point> = emptyList())