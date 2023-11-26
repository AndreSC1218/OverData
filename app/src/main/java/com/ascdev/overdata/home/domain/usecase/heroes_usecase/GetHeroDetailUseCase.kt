package com.ascdev.overdata.home.domain.usecase.heroes_usecase

import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail
import com.ascdev.overdata.home.domain.repository.HomeRepository

class GetHeroDetailUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(key: String): Result<HeroDetail> {
        return repository.getHeroDetail(key)
    }
}