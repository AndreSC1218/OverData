package com.ascdev.overdata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ascdev.overdata.home.presentation.gamemodes.GameModesScreen
import com.ascdev.overdata.home.presentation.hero_detail.HeroDetailScreen
import com.ascdev.overdata.home.presentation.heroes.HeroesScreen
import com.ascdev.overdata.home.presentation.maps.MapsScreen

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = RootScreen.Heroes.route) {
        addHeroesRoute(navController)
        addGameModesRoute()
        addMapsRoute()
    }
}

//Heroes Navigation
private fun NavGraphBuilder.addHeroesRoute(navController: NavController) {
    navigation(
        route = RootScreen.Heroes.route,
        startDestination = LeafScreen.Heroes.route
    ) {
        showHeroes(navController)
        showHeroDetail()
    }
}

private fun NavGraphBuilder.showHeroes(navController: NavController) {
    composable(
        route = LeafScreen.Heroes.route,
    ) {
        HeroesScreen(onHeroDetail = {
            navController.navigate(LeafScreen.HeroDetail.route + "?heroKey=$it")
        })
    }
}

private fun NavGraphBuilder.showHeroDetail() {
    composable(
        route = LeafScreen.HeroDetail.route + "?heroKey={heroKey}",
        arguments = listOf(navArgument("heroKey") {
            type = NavType.StringType
        })
    ) {
        HeroDetailScreen()
    }
}
//end of heroes navigation

//Game Modes Navigation
private fun NavGraphBuilder.addGameModesRoute() {
    navigation(
        route = RootScreen.GameModes.route,
        startDestination = LeafScreen.GameModes.route
    ) {
        showGameModes()
    }
}

private fun NavGraphBuilder.showGameModes() {
    composable(route = LeafScreen.GameModes.route) {
        GameModesScreen()
    }
}
//end of Game Modes navigation


//Maps Navigation
private fun NavGraphBuilder.addMapsRoute() {
    navigation(
        route = RootScreen.Maps.route,
        startDestination = LeafScreen.Maps.route
    ) {
        showMaps()
    }
}

private fun NavGraphBuilder.showMaps() {
    composable(route = LeafScreen.Maps.route) {
        MapsScreen()
    }
}
//end of Maps Navigation