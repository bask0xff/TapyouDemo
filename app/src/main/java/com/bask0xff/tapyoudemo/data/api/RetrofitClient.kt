package com.bask0xff.tapyoudemo.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// API здесь https://hr-challenge.dev.tapyou.com/swagger-ui.html?urls.primaryName=mobile#/mobile-test-controller/pointsUsingGET
object RetrofitClient {

    private const val BASE_URL = "https://hr-challenge.dev.tapyou.com/api/test/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}