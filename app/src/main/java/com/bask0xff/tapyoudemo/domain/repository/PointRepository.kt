package com.bask0xff.tapyoudemo.domain.repository

import com.bask0xff.tapyoudemo.domain.model.Point

interface PointRepository {
    suspend fun getPoints(count: Int): Result<List<Point>>
}