package org.dgeek.navigationexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.dgeek.navigationexample.ui.screen.GridScreen
import org.dgeek.navigationexample.ui.screen.HomeScreen
import org.dgeek.navigationexample.ui.screen.ListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier,
    storeOwner: ViewModelStoreOwner
) {
    NavHost(navController = navController, startDestination = NavItem.Home.screenRoute) {
        composable(NavItem.Home.screenRoute) { backEntry ->
//            backEntry.
            HomeScreen(
                modifier
            )
//                viewModel(viewModelStoreOwner = storeOwner, key = NavItem.Home.screenRoute)
        }
        composable(NavItem.List.screenRoute) {
                backEntry ->
            ListScreen(modifier)
        }
        composable(NavItem.Grid.screenRoute) {
                backEntry ->
            GridScreen(modifier)
        }
    }
}