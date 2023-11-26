package com.ascdev.overdata.home.data.repositories

import com.ascdev.overdata.home.data.remote.OverDataApi
import com.ascdev.overdata.home.data.remote.dto.gamemodes.toGameMode
import com.ascdev.overdata.home.data.remote.dto.hero.toHero
import com.ascdev.overdata.home.data.remote.dto.hero_detail.toHeroDetail
import com.ascdev.overdata.home.domain.models.gamemodes.GameMode
import com.ascdev.overdata.home.domain.models.hero.Hero
import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail
import com.ascdev.overdata.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val api: OverDataApi
) : HomeRepository {
    override suspend fun getAllHeroes(): Result<List<Hero>> {
        return try {
            val response = api.getAllHeroes()
            val heroes = response.map { it.toHero() }
            Result.success(heroes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getHeroDetail(herokey: String): Result<HeroDetail> {
        return try {
            val response = api.getHeroDetail(herokey).toHeroDetail()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAllGameModes(): Result<List<GameMode>> {
        return try {
            val response = api.getAllGameModes()
            val gamemodes = response.map { it.toGameMode() }
            Result.success(gamemodes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}