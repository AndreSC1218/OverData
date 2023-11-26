package com.ascdev.overdata.home.domain.usecase.heroes_usecase

import com.ascdev.overdata.home.domain.models.hero.Hero
import com.ascdev.overdata.home.domain.repository.HomeRepository

class GetAllHeroesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Hero>> {
        return repository.getAllHeroes()
    }
}