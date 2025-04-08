package com.example.ourfridgeapp.ui.fridge.contract

import com.example.ourfridgeapp.base.UiEvent
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel

sealed interface FridgeUiEvent: UiEvent {
    data class InsertIngredient(val fridgeUiModel: IngredientUiModel): FridgeUiEvent
    data class DeleteIngredient(val fridgeUiModel: IngredientUiModel): FridgeUiEvent
}