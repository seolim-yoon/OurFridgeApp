package com.example.ourfridgeapp.ui.ingredient.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.ButtonItem
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEvent
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiState
import com.example.ourfridgeapp.ui.ingredient.item.AddIngredientInputItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@Composable
internal fun AddIngredientScreen(
    state: IngredientUiState,
    onEvent: (IngredientUiEvent) -> Unit,
    onClickSave: (IngredientUiModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_20dp))
    ) {
        AddIngredientInputItem(
            inputName = state.draftIngredient?.name.orEmpty(),
            inputMemo = state.draftIngredient?.memo.orEmpty(),
            onNameChange = { onEvent(IngredientUiEvent.InputEvent.InputName(it)) },
            onSpaceSelect = { onEvent(IngredientUiEvent.InputEvent.InputSpaceType(it.toString())) },
            onCountQuantity = { ingredient, type ->
                onEvent(IngredientUiEvent.InputEvent.InputQuantity(ingredient.quantity)) },
            onMemoChange = { onEvent(IngredientUiEvent.InputEvent.InputMemo(it)) },
            modifier = Modifier.weight(1f),
        )

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
            onClickSave = {}
        )
    }
}