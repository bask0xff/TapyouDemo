package com.bask0xff.tapyoudemo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bask0xff.tapyoudemo.domain.model.Point
import com.bask0xff.tapyoudemo.domain.usecase.GetPointsUseCase
import kotlinx.coroutines.launch
import com.bask0xff.tapyoudemo.presentation.util.Result

class MainViewModel(private val getPointsUseCase: GetPointsUseCase) : ViewModel() {
    private val _state = MutableLiveData<MainScreenState>()
    val state: LiveData<MainScreenState> get() = _state

    fun fetchPoints(count: Int) {
        _state.value = MainScreenState(isLoading = true)
        viewModelScope.launch {
            when (val result = getPointsUseCase(count)) {
                is Result.Success -> _state.postValue(MainScreenState(points = result.data))
                is Result.Error -> _state.postValue(MainScreenState(error = result.exception.message ?: "Unknown error"))
            }
        }
    }
}

data class MainScreenState(
    val isLoading: Boolean = false,
    val points: List<Point> = emptyList(),
    val error: String? = null
)