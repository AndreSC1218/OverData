package com.ascdev.overdata.home.data.remote

import com.ascdev.overdata.home.data.remote.dto.hero_detail.HeroDetailDto
import com.ascdev.overdata.home.data.remote.dto.hero.HeroDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OverDataApi {
    companion object{
        const val BASE_URL = "https://overfast-api.tekrop.fr/"
    }

    @GET("heroes")
    suspend fun getAllHeroes(): List<HeroDto>

    @GET("heroes/{hero_key}")
    suspend fun getHeroDetail(@Path("hero_key") heroKey: String): HeroDetailDto

}