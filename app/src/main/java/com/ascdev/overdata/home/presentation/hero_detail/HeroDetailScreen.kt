package com.ascdev.overdata.home.presentation.hero_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ascdev.overdata.core.presentation.OverDataCircularProgress
import com.ascdev.overdata.core.presentation.OverDataConnectionError
import com.ascdev.overdata.home.presentation.hero_detail.components.AbilitySection
import com.ascdev.overdata.home.presentation.hero_detail.components.HeroDescription
import com.ascdev.overdata.home.presentation.hero_detail.components.HeroHeader
import com.ascdev.overdata.home.presentation.hero_detail.components.StorySection

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroDetailScreen(
    viewModel: HeroDetailViewModel = hiltViewModel(),
) {

    val state = viewModel.state

    Scaffold {
        if (state.isError) {
            OverDataConnectionError(onRetry = { viewModel.getHeroDetail() })
        } else if (state.heroDetail != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    HeroHeader(heroDetail = state.heroDetail)
                    HeroDescription(story = state.heroDetail.story)
                    AbilitySection(abilities = state.heroDetail.abilities)
                    StorySection(story = state.heroDetail.story)
                }
            }
        } else if (state.isLoading) {
            OverDataCircularProgress()
        }
    }
}