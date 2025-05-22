package com.bask0xff.tapyoudemo.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bask0xff.tapyoudemo.di.AppModule

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(AppModule.provideGetPointsUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
