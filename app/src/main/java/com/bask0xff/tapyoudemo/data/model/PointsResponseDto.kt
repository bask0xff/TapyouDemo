package com.bask0xff.tapyoudemo.data.model

data class PointsResponseDto(
    val points: List<PointDto>
)

data class PointDto(
    val x: Double,
    val y: Double
)