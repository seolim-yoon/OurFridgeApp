package com.example.ourfridgeapp.util

import kotlinx.serialization.Serializable

sealed interface ScreenType {
    @Serializable
    data object Home: ScreenType

    @Serializable
    data object Fridge: ScreenType

    @Serializable
    data object Setting: ScreenType

    @Serializable
    data object AddIngredient: ScreenType
}