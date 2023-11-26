package com.ascdev.overdata.home.presentation.gamemodes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascdev.overdata.home.domain.usecase.gamemodes_usecase.GetAllGameModesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameModesViewModel @Inject constructor(
    private val getAllGameModesUseCase: GetAllGameModesUseCase
):ViewModel(){
    var state by mutableStateOf(GameModesState())
        private set

    init {
        viewModelScope.launch {
            getAllGameModesUseCase().onSuccess {
                state = state.copy(
                    gamemodes = it
                )
            }.onFailure {
                state = state.copy(
                    isError = true
                )
            }
        }
    }
}