package com.ascdev.overdata.home.domain.usecase.maps_usecase

import com.ascdev.overdata.home.domain.models.map.Map
import com.ascdev.overdata.home.domain.repository.HomeRepository

class GetAllMapsUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Map>> {
        return repository.getAllMaps()
    }
}