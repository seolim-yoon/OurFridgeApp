package com.example.ourfridgeapp.ui.ingredient

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.example.data.repository.FridgeRepository
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.base.BaseViewModel
import com.example.ourfridgeapp.mapper.IngredientUiMapper
import com.example.ourfridgeapp.ui.fridge.uimodel.DraftIngredient
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEffect
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEvent
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiState
import com.example.ourfridgeapp.util.ScreenType
import com.example.ourfridgeapp.util.SpaceType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class IngredientViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fridgeRepository: FridgeRepository,
    private val ingredientUiMapper: IngredientUiMapper
) : BaseViewModel<IngredientUiState, IngredientUiEvent, IngredientUiEffect>() {
    override fun createInitialState(): IngredientUiState = IngredientUiState()

    override fun handleException(throwable: Throwable) {
        Log.e(this.javaClass.simpleName, throwable.message.toString())
    }

    init {
        viewModelLaunch(Dispatchers.IO) {
            val ingredient = fridgeRepository.getIngredientById(
                id = savedStateHandle.toRoute<ScreenType.AddIngredient>().id
            )
            setState {
                copy(
                    draftIngredient = ingredientUiMapper.mapToDraftIngredient(
                        ingredient
                    )
                )
            }
        }
    }

    private fun insertIngredient(draftIngredient: DraftIngredient) {
        viewModelLaunch(Dispatchers.IO) {
            draftIngredient.let {
                fridgeRepository.upsertIngredient(ingredientUiMapper.mapToIngredient(draftIngredient))
            }
        }
        setEffect {
            IngredientUiEffect.ShowSnackBar(R.string.msg_add_ingredient)
            IngredientUiEffect.ExitScreenWithResult(R.string.msg_add_ingredient)
        }
    }

    private fun deleteIngredient(draftIngredient: DraftIngredient) {
        viewModelLaunch(Dispatchers.IO) {
            fridgeRepository.deleteIngredient(ingredientUiMapper.mapToIngredient(draftIngredient))
        }
        setEffect {
            IngredientUiEffect.ShowSnackBar(R.string.msg_delete_ingredient)
            IngredientUiEffect.ExitScreenWithResult(R.string.msg_delete_ingredient)
        }
    }

    override fun onEvent(event: IngredientUiEvent) {
        when (event) {
            is IngredientUiEvent.InsertIngredient -> {
                insertIngredient(event.draftIngredient)
            }

            is IngredientUiEvent.DeleteIngredient -> {
                deleteIngredient(event.draftIngredient)
            }

            is IngredientUiEvent.InputEvent -> {
                onInputEvent(event)
            }
        }
    }

    private fun onInputEvent(event: IngredientUiEvent.InputEvent) {
        when (event) {
            is IngredientUiEvent.InputEvent.InputName -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            name = event.name
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputSpaceType -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            space = SpaceType.fromValueById(event.space)
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputCategory -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            category = event.category
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputQuantity -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            quantity = draftIngredient.quantity + event.type.value
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputPurchaseDate -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            purchaseDate = event.date
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputExpirationDate -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            expirationDate = event.date
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputDateViewType -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            dateViewType = event.viewType
                        )
                    )
                }
            }

            is IngredientUiEvent.InputEvent.InputMemo -> {
                setState {
                    copy(
                        draftIngredient = draftIngredient.copy(
                            memo = event.memo
                        )
                    )
                }
            }
        }
    }
}