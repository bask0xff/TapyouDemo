package com.bask0xff.tapyoudemo.data.api

import com.bask0xff.tapyoudemo.data.model.PointDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/test/points")
    suspend fun getPoints(@Query("count") count: Int): Response<List<PointDto>>
}