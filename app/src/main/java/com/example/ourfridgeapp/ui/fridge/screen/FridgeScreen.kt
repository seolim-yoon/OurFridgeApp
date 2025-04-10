package com.example.ourfridgeapp.ui.fridge.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
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
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onClickIngredientItem: (IngredientUiModel) -> Unit
) {
    Column {
        SpaceTabRowItem(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = onTabSelected
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
            tabs = listOf("냉장", "냉동", "김치냉장고"),
            selectedTabIndex = 0,
            onTabSelected = {  },
            onClickIngredientItem = {  }
        )
    }
}