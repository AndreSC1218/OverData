package com.ascdev.overdata.home.presentation.maps

import com.ascdev.overdata.home.domain.models.map.Map

data class MapsState(
    val maps: List<Map> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
)