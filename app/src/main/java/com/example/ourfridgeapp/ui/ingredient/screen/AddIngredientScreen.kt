package com.example.ourfridgeapp.ui.ingredient.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.ButtonItem
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEffect
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEvent
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiState
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientCategoryItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientDateItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientMemoItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientNameItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientQuantityItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientSpaceItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
internal fun AddIngredientScreen(
    state: IngredientUiState,
    onEvent: (IngredientUiEvent) -> Unit,
    effectFlow: Flow<IngredientUiEffect>,
    onSnackBarRequested: (Int) -> Unit,
    onNavigationRequested: (effect: IngredientUiEffect.ExitScreenWithResult) -> Unit
) {
    LaunchedEffect(Unit) {
        effectFlow.collect { effect ->
            when(effect) {
                is IngredientUiEffect.ShowSnackBar -> {
                }
                is IngredientUiEffect.ExitScreenWithResult -> {
                    onSnackBarRequested(effect.msg)

                    onNavigationRequested(effect)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_20dp))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_24dp)),
            modifier = Modifier.weight(1f)
        ) {

            InputIngredientNameItem(
                inputName = state.draftIngredient.name,
                onNameChange = { onEvent(IngredientUiEvent.InputEvent.InputName(it)) },
                )

            InputIngredientSpaceItem(
                onSpaceSelect = { onEvent(IngredientUiEvent.InputEvent.InputSpaceType(it.toString())) },
            )

            InputIngredientCategoryItem(
                onClickCategoryBtn = {}
            )

            InputIngredientQuantityItem(
                quantity = state.draftIngredient.quantity,
                onCountQuantity = { onEvent(IngredientUiEvent.InputEvent.InputQuantity(it)) }
            )

            InputIngredientDateItem(
                title = stringResource(R.string.purchase_date),
                onClickDateBtn = {}
            )

            InputIngredientDateItem(
                title = stringResource(R.string.expired_date),
                onClickDateBtn = {}
            )

            InputIngredientMemoItem(
                inputMemo = state.draftIngredient.memo,
                onMemoChange = { onEvent(IngredientUiEvent.InputEvent.InputMemo(it)) }
            )
        }

        Log.v("seolim", "id : " + state.draftIngredient.id)
        if (state.draftIngredient.id != 0) {
            ButtonItem(
                text = stringResource(R.string.delete),
                onClickButton = {
                    onEvent(IngredientUiEvent.DeleteIngredient(state.draftIngredient))
                }
            )
        }


        ButtonItem(
            text = stringResource(R.string.save),
            onClickButton = {
                onEvent(IngredientUiEvent.InsertIngredient(state.draftIngredient))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAddIngredientScreen() {
    OurFridgeAppTheme {
        AddIngredientScreen(
            state = IngredientUiState(),
            onEvent = {},
            effectFlow = emptyFlow(),
            onSnackBarRequested = {},
            onNavigationRequested = {}
        )
    }
}