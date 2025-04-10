package com.example.ourfridgeapp.ui.fridge.contract

import com.example.ourfridgeapp.base.UiEffect
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel

sealed interface FridgeUiEffect: UiEffect {
    data class MoveIngredientScreen(val ingredientUiModel: IngredientUiModel): FridgeUiEffect
}