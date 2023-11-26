package com.ascdev.overdata.home.data.remote

import com.ascdev.overdata.home.data.remote.dto.gamemodes.GameModeDto
import com.ascdev.overdata.home.data.remote.dto.hero_detail.HeroDetailDto
import com.ascdev.overdata.home.data.remote.dto.hero.HeroDto
import com.ascdev.overdata.home.data.remote.dto.maps.MapDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OverDataApi {
    companion object {
        const val BASE_URL = "https://overfast-api.tekrop.fr/"
    }

    @GET("heroes")
    suspend fun getAllHeroes(): List<HeroDto>

    @GET("maps")
    suspend fun getAllMaps(): List<MapDto>

    @GET("gamemodes")
    suspend fun getAllGameModes(): List<GameModeDto>

    @GET("heroes/{hero_key}")
    suspend fun getHeroDetail(@Path("hero_key") heroKey: String): HeroDetailDto

}