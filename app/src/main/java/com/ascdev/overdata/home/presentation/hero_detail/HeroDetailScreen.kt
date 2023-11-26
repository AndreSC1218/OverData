package com.ascdev.overdata.home.presentation.hero_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ascdev.overdata.core.presentation.OverDataCircularProgress
import com.ascdev.overdata.core.presentation.OverDataConnectionError
import com.ascdev.overdata.home.domain.models.hero_detail.Ability
import com.ascdev.overdata.home.domain.models.hero_detail.Chapter
import com.ascdev.overdata.home.domain.models.hero_detail.HeroDetail
import com.ascdev.overdata.home.domain.models.hero_detail.Story
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

    var state = viewModel.state

    Scaffold {
        if (state.isError) {
            OverDataConnectionError(onRetry = { viewModel.getHeroDetail() })
        } else if (state.heroDetail != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    HeroHeader(heroDetail = state.heroDetail!!)
                    HeroDescription(story = state.heroDetail!!.story)
                    AbilitySection(abilities = state.heroDetail!!.abilities)
                    StorySection(story = state.heroDetail!!.story)
                }
            }
        } else if (state.isLoading) {
            OverDataCircularProgress()
        }
    }
}