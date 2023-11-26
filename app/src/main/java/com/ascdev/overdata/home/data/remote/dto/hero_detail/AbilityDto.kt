package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.Ability

data class AbilityDto(
    val description: String,
    val icon: String,
    val name: String,
    val video: VideoDto
)

fun AbilityDto.toAbility(): Ability {
    return Ability(
        description = this.description,
        icon = this.icon,
        name = this.name,
        video = this.video.toVideo()
    )
}
