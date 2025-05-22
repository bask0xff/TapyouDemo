package com.bask0xff.tapyoudemo.di

import com.bask0xff.tapyoudemo.data.api.RetrofitClient
import com.bask0xff.tapyoudemo.data.repository.PointRepositoryImpl
import com.bask0xff.tapyoudemo.domain.repository.PointRepository
import com.bask0xff.tapyoudemo.domain.usecase.GetPointsUseCase

object AppModule {
    fun provideGetPointsUseCase(): GetPointsUseCase {
        return GetPointsUseCase(providePointRepository())
    }

    private fun providePointRepository(): PointRepository {
        return PointRepositoryImpl(RetrofitClient.apiService)
    }
}