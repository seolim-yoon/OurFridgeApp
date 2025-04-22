package com.example.ourfridgeapp.ui.ingredient.contract

import com.example.ourfridgeapp.base.UiEvent
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient
import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.DateViewType
import com.example.ourfridgeapp.util.NumberCountType

sealed interface IngredientUiEvent: UiEvent {
    data class InsertIngredient(val draftIngredient: DraftIngredient): IngredientUiEvent
    data class DeleteIngredient(val draftIngredient: DraftIngredient): IngredientUiEvent

    sealed interface InputEvent: IngredientUiEvent {
        data class InputName(val name: String) : InputEvent
        data class InputSpaceType(val space: Int) : InputEvent
        data class InputCategory(val category: CategoryType) : InputEvent
        data class InputQuantity(val type: NumberCountType) : InputEvent
        data class InputPurchaseDate(val date: String) : InputEvent
        data class InputExpirationDate(val date: String) : InputEvent
        data class InputDateViewType(val viewType: DateViewType) : InputEvent
        data class InputMemo(val memo: String) : InputEvent
    }
}