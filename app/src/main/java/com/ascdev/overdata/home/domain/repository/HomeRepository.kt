package com.ascdev.overdata.home.domain.repository

import com.ascdev.overdata.home.domain.models.hero.Hero
import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail

interface HomeRepository {
    suspend fun getAllHeroes() : Result<List<Hero>>
    suspend fun getHeroDetail(key: String) : Result<HeroDetail>
}