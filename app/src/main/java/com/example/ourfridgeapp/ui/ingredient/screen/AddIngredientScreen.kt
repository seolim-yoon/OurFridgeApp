package com.example.ourfridgeapp.ui.ingredient.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.ButtonItem
import com.example.ourfridgeapp.ui.common.DeleteButtonItem
import com.example.ourfridgeapp.ui.common.TitleItem
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEffect
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiEvent
import com.example.ourfridgeapp.ui.ingredient.contract.IngredientUiState
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientCategoryItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientDateItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientMemoItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientNameItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientQuantityItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientSpaceItem
import com.example.ourfridgeapp.ui.ingredient.item.InputIngredientViewTypeItem
import com.example.ourfridgeapp.ui.theme.Brown
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.Gray
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
    var isBottomSheetOpen by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        effectFlow.collect { effect ->
            when (effect) {
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
            .padding(
                vertical = dimensionResource(R.dimen.padding_12dp),
                horizontal = dimensionResource(R.dimen.padding_24dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_20dp)),
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(bottom = dimensionResource(R.dimen.padding_40dp))
        ) {

            InputIngredientNameItem(
                inputName = state.draftIngredient.name,
                onNameChange = { onEvent(IngredientUiEvent.InputEvent.InputName(it)) },
            )

            InputIngredientSpaceItem(
                selectedTabIndex = state.draftIngredient.space.id,
                onSpaceSelect = { onEvent(IngredientUiEvent.InputEvent.InputSpaceType(it)) },
            )

            InputIngredientCategoryItem(
                currentCategory = state.draftIngredient.category,
                onClickCategoryBtn = {
                    isBottomSheetOpen = true
                }
            )

            InputIngredientQuantityItem(
                quantity = state.draftIngredient.quantity,
                onCountQuantity = { onEvent(IngredientUiEvent.InputEvent.InputQuantity(it)) }
            )

            InputIngredientDateItem(
                title = stringResource(R.string.purchase_date),
                date = state.draftIngredient.purchaseDate,
                onSelectDate = { onEvent(IngredientUiEvent.InputEvent.InputPurchaseDate(it)) }
            )

            InputIngredientDateItem(
                title = stringResource(R.string.expired_date),
                date = state.draftIngredient.expirationDate,
                onSelectDate = { onEvent(IngredientUiEvent.InputEvent.InputExpirationDate(it)) }
            )

            InputIngredientViewTypeItem(
                selectedViewType = state.draftIngredient.dateViewType,
                onSelectedType = { onEvent(IngredientUiEvent.InputEvent.InputDateViewType(it)) }
            )

            InputIngredientMemoItem(
                inputMemo = state.draftIngredient.memo,
                onMemoChange = { onEvent(IngredientUiEvent.InputEvent.InputMemo(it)) }
            )

            if (state.draftIngredient.id != 0) {
                DeleteButtonItem(
                    onClickDeleteButton = {
                        onEvent(IngredientUiEvent.DeleteIngredient(state.draftIngredient))
                    }
                )
            }
        }
    }

    if (isBottomSheetOpen) {
        CategoryBottomSheet(
            currentCategory = state.draftIngredient.category,
            onClickCategoryItem = { category ->
                isBottomSheetOpen = false
                onEvent(IngredientUiEvent.InputEvent.InputCategory(category))
            },
            onDismissRequest = {
                isBottomSheetOpen = false
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