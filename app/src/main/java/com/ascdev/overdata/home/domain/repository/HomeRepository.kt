package com.ascdev.overdata.home.domain.repository

import com.ascdev.overdata.home.domain.models.gamemodes.GameMode
import com.ascdev.overdata.home.domain.models.hero.Hero
import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail
import com.ascdev.overdata.home.domain.models.map.Map

interface HomeRepository {
    suspend fun getAllHeroes(): Result<List<Hero>>
    suspend fun getAllMaps(): Result<List<Map>>
    suspend fun getHeroDetail(key: String): Result<HeroDetail>
    suspend fun getAllGameModes(): Result<List<GameMode>>
}