package com.example.ourfridgeapp.ui.ingredient.contract

import com.example.ourfridgeapp.base.UiEvent
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel

sealed interface IngredientUiEvent: UiEvent {
    data class InsertIngredient(val draftIngredient: DraftIngredient?): IngredientUiEvent
    data class DeleteIngredient(val ingredientUiModel: IngredientUiModel): IngredientUiEvent

    sealed interface InputEvent: IngredientUiEvent {
        data class InputName(val name: String) : InputEvent
        data class InputSpaceType(val space: String) : InputEvent
        data class InputCategory(val category: String) : InputEvent
        data class InputQuantity(val quantity: Int) : InputEvent
        data class InputPurchaseDate(val date: String) : InputEvent
        data class InputExpirationDate(val date: String) : InputEvent
        data class InputMemo(val memo: String) : InputEvent
    }
}