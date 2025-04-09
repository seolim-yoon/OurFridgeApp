package com.example.ourfridgeapp.ui.fridge.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.ui.fridge.item.FridgeListItem
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@Composable
internal fun FridgeScreen(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    ingredients: List<IngredientUiModel>,
) {
    Column {
        SpaceTabRowItem(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = onTabSelected
        )

        FridgeListItem(
            ingredients = ingredients
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFridgeScreen() {
    OurFridgeAppTheme {
        FridgeScreen(
            tabs = listOf("냉장", "냉동", "김치냉장고"),
            selectedTabIndex = 0,
            onTabSelected = {  },
            ingredients = List(3) { index ->
                IngredientUiModel(
                    id = index,
                    space = "",
                    category = "",
                    name = "재료 ${index + 1}",
                    quantity = 1 + index,
                    purchaseDate = "2025.04.01",
                    expirationDate = "2025.04.${16 + index}",
                    dDay = 9 - index,
                    memo = "memo"
                )
            }
        )
    }
}