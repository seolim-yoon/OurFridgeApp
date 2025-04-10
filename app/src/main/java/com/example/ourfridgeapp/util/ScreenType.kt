package com.example.ourfridgeapp.util

import androidx.annotation.StringRes
import com.example.ourfridgeapp.R
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenType(
    val isBackNavButton: Boolean,
    val isVisibleAddButton: Boolean,
    @StringRes val topBarTitleRes: Int
) {
    @Serializable
    data object Home : ScreenType(
        isBackNavButton = false,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.app_name
    )

    @Serializable
    data object Fridge : ScreenType(
        isBackNavButton = false,
        isVisibleAddButton = true,
        topBarTitleRes = R.string.app_name
    )

    @Serializable
    data object Setting : ScreenType(
        isBackNavButton = false,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.screen_setting
    )

    @Serializable
    data object AddIngredient : ScreenType(
        isBackNavButton = true,
        isVisibleAddButton = false,
        topBarTitleRes = R.string.add_ingredient
    )

    companion object {
        fun fromRoute(route: String): ScreenType = when (route) {
            Home::class.simpleName -> Home
            Fridge::class.simpleName -> Fridge
            Setting::class.simpleName -> Setting
            AddIngredient::class.simpleName -> AddIngredient
            else -> Home
        }
    }
}