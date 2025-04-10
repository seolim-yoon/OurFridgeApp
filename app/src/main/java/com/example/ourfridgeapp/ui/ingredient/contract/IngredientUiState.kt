package com.example.ourfridgeapp.ui.ingredient.contract

import com.example.ourfridgeapp.base.UiState
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient

data class IngredientUiState(
    val draftIngredient: DraftIngredient = DraftIngredient()
) : UiState

