package com.ascdev.overdata.navigation

sealed class RootScreen(val route: String) {
    object Heroes : RootScreen("heroes_root")
    object GameModes : RootScreen("game_modes_root")
    object Maps : RootScreen("maps_root")
}

sealed class LeafScreen(val route: String) {
    object Heroes : LeafScreen("heroes")
    object GameModes : LeafScreen("game_modes")
    object Maps : LeafScreen("maps")
    object HeroDetail : LeafScreen("hero_detail")
}