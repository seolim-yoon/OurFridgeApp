package com.example.ourfridgeapp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.util.ScreenType

data class NavigationItem(
    val route: ScreenType,
    @StringRes val titleRes: Int,
    val icon: ImageVector,
)

val navigationItemList: List<NavigationItem> = listOf(
    NavigationItem(
        route = ScreenType.Home,
        titleRes = R.string.screen_home,
        icon = Icons.Default.Home
    ),
    NavigationItem(
        route = ScreenType.Fridge,
        titleRes = R.string.screen_fridge,
        icon = Icons.Default.Kitchen
    ),
    NavigationItem(
        route = ScreenType.Setting,
        titleRes = R.string.screen_setting,
        icon = Icons.Default.Settings
    )
)

