package com.ascdev.overdata.home.presentation.home.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.SportsEsports
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ascdev.overdata.R
import com.ascdev.overdata.navigation.RootScreen
import com.ascdev.overdata.navigation.navigateToRootScreen

@Composable
fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentSelectedScreen: RootScreen
) {
    BottomAppBar(
        modifier = modifier.clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)),
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary,
        ) {

            NavigationBarItem(
                selected = currentSelectedScreen == RootScreen.Heroes,
                onClick = { navController.navigateToRootScreen(RootScreen.Heroes) },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.heroes_icon),
                        contentDescription = "prueba"
                    )
                },
                label = {
                    Text(text = "HEROES")
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
            NavigationBarItem(
                selected = currentSelectedScreen == RootScreen.GameModes,
                onClick = { navController.navigateToRootScreen(RootScreen.GameModes) },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.SportsEsports,
                        contentDescription = "prueba"
                    )
                },
                label = {
                    Text(text = "GAME MODES")
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
            NavigationBarItem(
                selected = currentSelectedScreen == RootScreen.Maps,
                onClick = { navController.navigateToRootScreen(RootScreen.Maps) },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Map,
                        contentDescription = "prueba"
                    )
                },
                label = {
                    Text(text = "MAPS")
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
        }
    }
}