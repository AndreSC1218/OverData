package com.ascdev.overdata.home.domain.models.hero_detail

data class HeroDetail (
    val abilities: List<Ability>,
    val description: String,
    val location: String,
    val name: String,
    val portrait: String,
    val role: String,
    val story: Story
)