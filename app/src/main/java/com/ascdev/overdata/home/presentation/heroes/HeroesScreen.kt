package com.ascdev.overdata.home.presentation.heroes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ascdev.overdata.core.presentation.OverDataCircularProgress
import com.ascdev.overdata.core.presentation.OverDataConnectionError
import com.ascdev.overdata.home.presentation.heroes.components.HeroItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesScreen(
    onHeroDetail: (String) -> Unit,
    viewModel: HeroesViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Scaffold {
        if (state.isError) {
            OverDataConnectionError(onRetry = { viewModel.getHeroes() })
        } else if (state.heroes.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(state.heroes) {
                    HeroItem(hero = it, onHeroDetail = { onHeroDetail(it.key) })
                }
            }
        } else if (state.isLoading) {
            OverDataCircularProgress()
        }
    }
}