package com.ascdev.overdata.home.presentation.hero_detail

import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail

data class HeroDetailState (
    val heroDetail: HeroDetail? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)