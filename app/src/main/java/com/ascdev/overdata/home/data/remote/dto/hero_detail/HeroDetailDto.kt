package com.ascdev.overdata.home.data.remote.dto.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail

data class HeroDetailDto(
    val abilities: List<AbilityDto>,
    val description: String,
    val location: String,
    val name: String,
    val portrait: String,
    val role: String,
    val story: StoryDto
)

fun HeroDetailDto.toHeroDetail(): HeroDetail {

    val abilities = this.abilities.map { it.toAbility() }
    val story = this.story.toStory()
    return HeroDetail(
        name = this.name,
        portrait = this.portrait,
        role = this.role,
        description = this.description,
        location = this.location,
        abilities = abilities,
        story = story
    )
}
