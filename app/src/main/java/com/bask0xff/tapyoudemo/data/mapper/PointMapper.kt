package com.bask0xff.tapyoudemo.data.mapper

import com.bask0xff.tapyoudemo.data.model.PointDto
import com.bask0xff.tapyoudemo.domain.model.Point

object PointMapper {
    fun toDomain(dto: PointDto): Point = Point(dto.x, dto.y)
    fun toDomainList(dtos: List<PointDto>): List<Point> = dtos.map { toDomain(it) }
}
