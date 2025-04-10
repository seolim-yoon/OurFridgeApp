package com.example.ourfridgeapp.util

import androidx.annotation.StringRes
import com.example.ourfridgeapp.R

enum class TopBarByScreenType(
    val route: String,
    val isBackNavButton: Boolean,
    val isVisibleAddButton: Boolean,
    @StringRes val topBarTitleRes: Int
) {
    HOME(
        route = "Home",
        isBackNavButton = false,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.app_name
    ),

    FRIDGE(
        route = "Fridge",
        isBackNavButton = false,
        isVisibleAddButton = true,
        topBarTitleRes = R.string.app_name
    ),

    SETTING(
        route = "Setting",
        isBackNavButton = false,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.screen_setting
    ),

    ADD_INGREDIENT(
        route = "AddIngredient",
        isBackNavButton = true,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.add_ingredient
    );

    companion object {
        fun getScreenType(route: String): TopBarByScreenType =
            entries.find { route.contains(it.route) } ?: HOME
    }
}