package com.ascdev.overdata.home.presentation.heroes

import com.ascdev.overdata.home.domain.models.hero.Hero

data class HeroesState (
    val heroes: List<Hero> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
)