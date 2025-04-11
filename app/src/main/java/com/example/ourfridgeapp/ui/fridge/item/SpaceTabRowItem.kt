package com.example.ourfridgeapp.ui.fridge.item

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.ui.fridge.screen.FridgeScreen
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@Composable
internal fun SpaceTabRowItem(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                },
                text = {
                    Text(
                        text = tab,
                        style = FridgeAppTheme.typography.title16
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceTabRowItem() {
    OurFridgeAppTheme {
        SpaceTabRowItem(
            tabs = listOf("냉장", "냉동", "김치냉장고"),
            selectedTabIndex = 0,
            onTabSelected = {  }
        )
    }
}