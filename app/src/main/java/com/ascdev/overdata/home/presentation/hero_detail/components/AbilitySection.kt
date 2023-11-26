package com.ascdev.overdata.home.presentation.hero_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ascdev.overdata.home.domain.models.hero_detail.Ability

@Composable
fun AbilitySection(abilities: List<Ability>) {
    Column(
    ) {
        abilities.forEach { ability ->
            AbilityItem(ability = ability)
        }
    }
}