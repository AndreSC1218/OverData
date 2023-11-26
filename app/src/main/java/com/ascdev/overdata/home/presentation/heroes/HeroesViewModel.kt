package com.ascdev.overdata.home.presentation.heroes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascdev.overdata.home.domain.usecase.heroes_usecase.HeroesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val heroesUseCases: HeroesUseCases,
) : ViewModel() {
    var state by mutableStateOf(HeroesState())
        private set

    init {
        getHeroes()
    }

    fun getHeroes() {
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            heroesUseCases.getAllHeroesUseCase().onSuccess {
                state = state.copy(
                    heroes = it
                )
            }.onFailure {
                state = state.copy(
                    isError = true
                )
            }
            state = state.copy(isLoading = false)
        }
    }
}