package com.ascdev.overdata.home.presentation.gamemodes

import com.ascdev.overdata.home.domain.models.gamemodes.GameMode

data class GameModesState (
    val gamemodes: List<GameMode> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
)