package com.example.ourfridgeapp.ui.fridge

import com.example.ourfridgeapp.base.BaseViewModel
import com.example.ourfridgeapp.base.LoadState
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEffect
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEvent
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor(

): BaseViewModel<FridgeUiState, FridgeUiEvent, FridgeUiEffect>() {
    override fun createInitialState(): FridgeUiState = FridgeUiState()

    override fun handleException(throwable: Throwable) {
        setState {
            copy(
                loadState = LoadState.Error(throwable)
            )
        }
    }

    override fun onEvent(event: FridgeUiEvent) {
        TODO("Not yet implemented")
    }

}