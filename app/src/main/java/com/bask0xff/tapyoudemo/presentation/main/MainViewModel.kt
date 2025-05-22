package com.bask0xff.tapyoudemo.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bask0xff.tapyoudemo.R
import com.bask0xff.tapyoudemo.domain.model.Point
import com.bask0xff.tapyoudemo.domain.usecase.GetPointsUseCase
import kotlinx.coroutines.launch
import com.bask0xff.tapyoudemo.presentation.util.Result

class MainViewModel(private val getPointsUseCase: GetPointsUseCase) : ViewModel() {
    private val TAG = "MainViewModel"
    private val _state = MutableLiveData<MainScreenState>()
    val state: LiveData<MainScreenState> get() = _state

    fun fetchPoints(count: Int) {
        Log.d(TAG, "fetchPoints: request points: $count")
        _state.value = MainScreenState(isLoading = true)
        viewModelScope.launch {
            val result: Result<List<Point>> = getPointsUseCase(count)
            when (result) {
                is Result.Success -> _state.postValue(MainScreenState(points = result.data))
                is Result.Error -> _state.postValue(MainScreenState(error = (result.exception.message ?: R.string.unknown_error).toString()))
            }
        }
    }
}

data class MainScreenState(
    val isLoading: Boolean = false,
    val points: List<Point> = emptyList(),
    val error: String? = null
)