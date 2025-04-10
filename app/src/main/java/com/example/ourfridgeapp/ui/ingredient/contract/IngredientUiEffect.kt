package com.example.ourfridgeapp.ui.ingredient.contract

import com.example.ourfridgeapp.base.UiEffect

sealed interface IngredientUiEffect: UiEffect {
    data class ShowSnackBar(val msg: Int): IngredientUiEffect
    data class ExitScreenWithResult(val msg: Int): IngredientUiEffect
}