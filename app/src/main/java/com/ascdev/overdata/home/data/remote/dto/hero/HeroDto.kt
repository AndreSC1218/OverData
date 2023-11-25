package com.ascdev.overdata.home.data.remote.dto.hero

import com.ascdev.overdata.home.domain.models.hero.Hero

data class HeroDto(
    val key: String,
    val name: String,
    val portrait: String,
    val role: String
)

fun HeroDto.toHero(): Hero {
    return Hero(
        key = this.key,
        name = this.name,
        portrait = this.portrait,
        role = this.role
    )
}