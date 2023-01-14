package org.dgeek.navigationexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.dgeek.navigationexample.ui.screen.GridScreen
import org.dgeek.navigationexample.ui.screen.HomeChildScreen
import org.dgeek.navigationexample.ui.screen.HomeScreen
import org.dgeek.navigationexample.ui.screen.ListScreen

@Composable
fun HomeNavigationGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavItem.HomeBigChild.screenRoute
    ) {
        composable(HomeNavItem.HomeBigChild.screenRoute) { backnav ->
            HomeChildScreen(
                modifier = modifier, title = HomeNavItem.HomeBigChild.screenRoute, navController = navController
            )
        }
        composable(HomeNavItem.HomeMidChild.screenRoute) { backnav ->
            HomeChildScreen(
                modifier = modifier,
                title = HomeNavItem.HomeMidChild.screenRoute, navController = navController
            )
        }
        composable(HomeNavItem.HomeSmalChild.screenRoute) { backnav ->
            HomeChildScreen(
                modifier = modifier,
                title = HomeNavItem.HomeSmalChild.screenRoute, navController = navController
            )
        }
    }

}