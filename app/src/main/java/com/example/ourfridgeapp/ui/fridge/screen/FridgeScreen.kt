package com.example.ourfridgeapp.ui.fridge.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiEvent
import com.example.ourfridgeapp.ui.fridge.contract.FridgeUiState
import com.example.ourfridgeapp.ui.fridge.item.FridgeListItem
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@Composable
internal fun FridgeScreen(
    state: FridgeUiState,
    onEvent: (FridgeUiEvent) -> Unit,
    onClickIngredientItem: (IngredientUiModel) -> Unit
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    Column {
        SpaceTabRowItem(
            tabs = listOf("냉장실", "냉동실", "김치냉장고", "팬트리"), // TODO : 분리
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { idx ->
                selectedTabIndex = idx
            }
        )

        FridgeListItem(
            ingredients = state.ingredientList,
            onClickIngredientItem = onClickIngredientItem
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFridgeScreen() {
    OurFridgeAppTheme {
        FridgeScreen(
            state = FridgeUiState(),
            onEvent = {},
            onClickIngredientItem = {  }
        )
    }
}