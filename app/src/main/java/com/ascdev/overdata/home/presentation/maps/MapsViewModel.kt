package com.ascdev.overdata.home.presentation.maps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascdev.overdata.home.domain.usecase.maps_usecase.GetAllMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val getAllMapsUseCase: GetAllMapsUseCase
) : ViewModel() {
    var state by mutableStateOf(MapsState())
        private set

    init {
        getMaps()
    }

    private fun getMaps() {
        viewModelScope.launch {
            state = state.copy(isError = false)
            state = state.copy(isLoading = true)
            getAllMapsUseCase().onSuccess {
                state = state.copy(
                    maps = it
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