package org.dgeek.navigationexample.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.dgeek.navigationexample.ui.navigation.HomeNavItem
import org.dgeek.navigationexample.ui.navigation.HomeNavigationGraph
import org.dgeek.navigationexample.ui.viewmodel.HomeChildViewModel
import org.dgeek.navigationexample.ui.viewmodel.HomeViewModel

@Composable
fun HomeChildScreen(
    modifier: Modifier,
    viewModel: HomeChildViewModel = viewModel(),
    title: String,
    navController:NavController
) {
    val number by viewModel.number.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
        Button(onClick = { viewModel.increment() }) {
            Text(text = "IncreaseCount  $number")
        }

        Button(onClick = {
            navigateToScreen(
                navController = navController,
                route = HomeNavItem.HomeBigChild.screenRoute
            )
        }) {
            Text(text = "Move To Big")
        }

        Button(onClick = {
            navigateToScreen(
                navController = navController,
                route = HomeNavItem.HomeMidChild.screenRoute
            )
        }) {
            Text(text = "Move To Mid ")
        }

        Button(onClick = {
            navigateToScreen(
                navController = navController,
                route = HomeNavItem.HomeSmalChild.screenRoute
            )
        }) {
            Text(text = "Move To Small")
        }

    }
}

fun navigateToScreen(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
                saveState = true
            }
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}
