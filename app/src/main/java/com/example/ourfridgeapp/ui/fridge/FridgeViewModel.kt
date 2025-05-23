package com.example.ourfridgeapp.ui.fridge

import com.example.data.repository.FridgeRepository
import com.example.ourfridgeapp.base.BaseViewModel
import com.example.ourfridgeapp.base.LoadState
import com.example.ourfridgeapp.mapper.IngredientUiMapper
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEffect
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEvent
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiState
import com.example.ourfridgeapp.util.SpaceType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class FridgeViewModel @Inject constructor(
    private val fridgeRepository: FridgeRepository,
    private val ingredientUiMapper: IngredientUiMapper
) : BaseViewModel<FridgeUiState, FridgeUiEvent, FridgeUiEffect>() {
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

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getAllIngredient() {
        viewModelLaunch(Dispatchers.IO) {
            state.map {
                it.spaceType
            }
                .distinctUntilChanged()
                .flatMapLatest { space ->
                    fridgeRepository.getIngredientBySpaceType(currentState.spaceType.title)
                }
                .collectLatest { ingredients ->
                    setState {
                        copy(
                            ingredientList = ingredientUiMapper.mapToIngredientUiModelList(
                                ingredients
                            )
                        )
                    }
                }
        }
    }

    override fun onEvent(event: FridgeUiEvent) {
        when (event) {
            is FridgeUiEvent.SelectSpaceType -> {
                setState {
                    copy(
                        spaceType = SpaceType.fromValueByString(event.spaceType)
                    )
                }
            }
        }


    }
}