package com.ascdev.overdata.home.presentation.hero_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ascdev.overdata.core.presentation.OverDataCircularProgress
import com.ascdev.overdata.core.presentation.OverDataConnectionError
import com.ascdev.overdata.home.domain.models.hero_detail.Ability

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroDetailScreen(
    viewModel: HeroDetailViewModel = hiltViewModel(),
) {

    var state = viewModel.state

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isError) {
                OverDataConnectionError(onRetry = { viewModel.getHeroDetail() })
            } else if (state.heroDetail != null) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                    Text(
                        text = "Hero: ${state.heroDetail?.name}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    // Mostrar habilidades
                    state.heroDetail!!.abilities.forEach { ability ->
                        AbilityItem(ability = ability)
                    }
                }
            } else if (state.isLoading) {
                OverDataCircularProgress()
            }
        }
    }
}
@Composable
fun AbilityItem(ability: Ability) {
    Column {
        Text(text = "Name: ${ability.name}")
        Text(text = "Description: ${ability.description}")
        // Mostrar más detalles si es necesario...
    }
}