package com.ascdev.overdata.home.domain.usecase.gamemodes_usecase

import com.ascdev.overdata.home.domain.models.gamemodes.GameMode
import com.ascdev.overdata.home.domain.repository.HomeRepository

class GetAllGameModesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<GameMode>> {
        return repository.getAllGameModes()
    }
}