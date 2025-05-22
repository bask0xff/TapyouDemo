package com.bask0xff.tapyoudemo.domain.repository

import com.bask0xff.tapyoudemo.domain.model.Point
import com.bask0xff.tapyoudemo.presentation.util.Result

interface PointRepository {
    suspend fun getPoints(count: Int): Result<List<Point>>
}