package com.example.ourfridgeapp.ui.fridge.contract

import com.example.ourfridgeapp.base.LoadState
import com.example.ourfridgeapp.base.UiState
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.util.SpaceType

data class FridgeUiState(
    val loadState: LoadState = LoadState.Success,
    val spaceType: SpaceType = SpaceType.FRIDGE,
    val ingredientList: List<IngredientUiModel> = emptyList(),
) : UiState

