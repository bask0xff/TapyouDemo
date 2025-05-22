package com.bask0xff.tapyoudemo.presentation.points

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PointsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PointsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PointsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}