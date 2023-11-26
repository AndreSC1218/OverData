package com.ascdev.overdata.home.data.remote.dto.maps

import com.ascdev.overdata.home.domain.models.map.Map

data class MapDto(
    val location: String,
    val name: String,
    val screenshot: String
)

fun MapDto.toMap(): Map {
    return Map(
        location = this.location,
        name = this.name,
        screenshot = this.screenshot
    )
}