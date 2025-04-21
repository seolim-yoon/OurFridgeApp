package com.example.ourfridgeapp.ui.fridge.contract

import com.example.ourfridgeapp.base.UiEvent

sealed interface FridgeUiEvent: UiEvent {
    data class SelectSpaceType(val spaceType: String): FridgeUiEvent

}