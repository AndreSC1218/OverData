package com.ascdev.overdata.home.presentation.hero_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascdev.overdata.home.domain.usecase.heroes_usecase.HeroesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val heroesUseCases: HeroesUseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var state by mutableStateOf(HeroDetailState())
        private set

    val key = savedStateHandle.get<String>("heroKey")
    init {
            getHeroDetail()
    }

    fun getHeroDetail(){
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            if (key != null) {
                heroesUseCases.getHeroDetailUseCase(key).onSuccess {
                    state = state.copy(
                        heroDetail = it
                    )
                }.onFailure {throwable ->
                    throwable.printStackTrace()
                    state = state.copy(
                        isError = true
                    )
                }
            }
            state = state.copy(isLoading = false)
        }
    }
}