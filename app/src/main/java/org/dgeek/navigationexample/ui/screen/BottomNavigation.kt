package org.dgeek.navigationexample.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import org.dgeek.navigationexample.ui.navigation.NavItem

@Composable
fun BottomNavigationUi(navController: NavController) {
    val items = listOf(
        NavItem.Home,
        NavItem.List,
        NavItem.Grid
    )
    BottomAppBar(
        containerColor = Color.White,
    ) {
        items.forEach { item ->
            Column(modifier = Modifier.weight(1f).clickable {
                navController.navigate(item.screenRoute){
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
            }, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
                Text(text = item.title)
            }
        }
    }
}