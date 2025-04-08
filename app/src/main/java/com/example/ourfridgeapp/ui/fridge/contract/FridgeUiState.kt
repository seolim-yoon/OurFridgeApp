package com.example.ourfridgeapp.ui.fridge.contract

import com.example.ourfridgeapp.base.LoadState
import com.example.ourfridgeapp.base.UiState
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel

data class FridgeUiState(
    val loadState: LoadState = LoadState.Success,
    val historyList: List<IngredientUiModel> = emptyList()
) : UiState