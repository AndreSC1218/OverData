package com.ascdev.overdata.home.data.remote.dto.gamemodes

import com.ascdev.overdata.home.domain.models.gamemodes.GameMode

data class GameModeDto(
    val description: String,
    val icon: String,
    val key: String,
    val name: String,
    val screenshot: String
)

fun GameModeDto.toGameMode(): GameMode {
    return GameMode(
        description = this.description,
        icon = this.icon,
        key = this.key,
        name = this.name,
        screenshot = this.screenshot
    )
}