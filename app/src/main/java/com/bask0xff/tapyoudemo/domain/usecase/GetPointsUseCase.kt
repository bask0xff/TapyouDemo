package com.bask0xff.tapyoudemo.domain.usecase

import com.bask0xff.tapyoudemo.domain.model.Point
import com.bask0xff.tapyoudemo.domain.repository.PointRepository
import com.bask0xff.tapyoudemo.presentation.util.Result

class GetPointsUseCase(private val repository: PointRepository) {
    suspend operator fun invoke(count: Int): Result<List<Point>> {
        return repository.getPoints(count)
    }
}