package org.dgeek.navigationexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.dgeek.navigationexample.ui.screen.GridScreen
import org.dgeek.navigationexample.ui.screen.HomeScreen
import org.dgeek.navigationexample.ui.screen.ListScreen

@Composable
fun NavigationGraph(navController: NavHostController,modifier: Modifier) {
    NavHost(navController = navController, startDestination = NavItem.Home.screenRoute) {
        composable(NavItem.Home.screenRoute) {
            HomeScreen(modifier)
        }
        composable (NavItem.List.screenRoute){
            ListScreen(modifier)
        }
        composable (NavItem.Grid.screenRoute){
            GridScreen(modifier)
        }
    }
}