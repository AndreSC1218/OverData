package com.ascdev.overdata.home.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ascdev.overdata.home.presentation.home.components.HomeBottomNavigation
import com.ascdev.overdata.navigation.NavigationHost
import com.ascdev.overdata.navigation.currentScreenAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val currentSelectedScreen by navController.currentScreenAsState()

    Scaffold(
        bottomBar = {
            HomeBottomNavigation(
                navController = navController,
                currentSelectedScreen = currentSelectedScreen
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavigationHost(navController = navController)
        }
    }
}