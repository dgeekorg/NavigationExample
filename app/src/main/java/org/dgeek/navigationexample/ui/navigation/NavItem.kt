package org.dgeek.navigationexample.ui.navigation

import org.dgeek.navigationexample.R

sealed class NavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home : NavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object List : NavItem("List", R.drawable.ic_baseline_list_24, "list")
    object Grid : NavItem("Grid", R.drawable.ic_baseline_grid_on_24, "grid")
}


sealed class HomeNavItem(val screenRoute: String){
    object HomeBigChild:HomeNavItem("home/big_child")
    object HomeMidChild:HomeNavItem("home/mid_child")
    object HomeSmalChild:HomeNavItem("home/small_child")
}