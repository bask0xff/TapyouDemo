package com.bask0xff.tapyoudemo.data.repository

import android.util.Log
import com.bask0xff.tapyoudemo.data.api.ApiService
import com.bask0xff.tapyoudemo.data.mapper.PointMapper
import com.bask0xff.tapyoudemo.domain.model.Point
import com.bask0xff.tapyoudemo.domain.repository.PointRepository
import com.bask0xff.tapyoudemo.presentation.util.Result

class PointRepositoryImpl(private val apiService: ApiService) : PointRepository {
    private val TAG = "PointRepositoryImpl"

    override suspend fun getPoints(count: Int): Result<List<Point>> {
        return try {
            val response = apiService.getPoints(count)
            if (response.isSuccessful) {
                val pointsResponse = response.body()
                if (pointsResponse != null) {
                    Log.d(TAG, "getPoints: ${pointsResponse.points}")
                    Result.Success(PointMapper.toDomainList(pointsResponse.points))
                } else {
                    Result.Error(Exception("Empty response body"))
                }
            } else {
                Result.Error(Exception("API error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}