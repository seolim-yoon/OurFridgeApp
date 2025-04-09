package com.example.ourfridgeapp.ui.fridge

import com.example.data.repository.FridgeRepository
import com.example.ourfridgeapp.base.BaseViewModel
import com.example.ourfridgeapp.base.LoadState
import com.example.ourfridgeapp.mapper.IngredientUiMapper
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEffect
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEvent
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor(
    private val fridgeRepository: FridgeRepository,
    private val ingredientUiMapper: IngredientUiMapper
): BaseViewModel<FridgeUiState, FridgeUiEvent, FridgeUiEffect>() {
    override fun createInitialState(): FridgeUiState = FridgeUiState()

    override fun handleException(throwable: Throwable) {
        setState {
            copy(
                loadState = LoadState.Error(throwable)
            )
        }
    }

    init {
        getAllIngredient()
    }

    private fun getAllIngredient() {
        viewModelLaunch {
            fridgeRepository.getAllIngredient().collect { ingredients ->
                setState {
                    copy(
                        ingredientList = ingredientUiMapper.mapToIngredientUiModelList(ingredients)
                    )
                }
            }
        }
    }

    override fun onEvent(event: FridgeUiEvent) {

    }
}