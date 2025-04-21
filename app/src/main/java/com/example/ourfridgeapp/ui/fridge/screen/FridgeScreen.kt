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
import com.example.ourfridgeapp.util.SpaceType

@Composable
internal fun FridgeScreen(
    state: FridgeUiState,
    onEvent: (FridgeUiEvent) -> Unit,
    onClickIngredientItem: (IngredientUiModel) -> Unit
) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabList = SpaceType.entries.map { it.title }

    Column {
        SpaceTabRowItem(
            tabs = tabList,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { idx ->
                selectedTabIndex = idx
                onEvent(FridgeUiEvent.SelectSpaceType(tabList[idx]))
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