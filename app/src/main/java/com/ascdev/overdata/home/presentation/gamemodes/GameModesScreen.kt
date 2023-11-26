package com.ascdev.overdata.home.presentation.gamemodes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ascdev.overdata.core.presentation.OverDataCircularProgress
import com.ascdev.overdata.core.presentation.OverDataConnectionError
import com.ascdev.overdata.home.presentation.gamemodes.components.GameModeItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameModesScreen(
    viewModel: GameModesViewModel = hiltViewModel()
) {

    var state = viewModel.state

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            if(state.isError){
                OverDataConnectionError(onRetry = { viewModel.getGameModes() })
            }else if(state.gamemodes.isNotEmpty()){
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.gamemodes) {
                        GameModeItem(gameMode = it)
                    }
                }
            } else if(state.isLoading){
                OverDataCircularProgress()
            }
        }
    }
}