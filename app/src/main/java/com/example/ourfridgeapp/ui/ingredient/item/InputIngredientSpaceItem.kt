package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.runtime.Composable
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem

@Composable
internal fun InputIngredientSpaceItem(
    selectedTabIndex: Int,
    onSpaceSelect: (Int) -> Unit
) {
    SpaceTabRowItem(
        tabs = listOf("냉장실", "냉동실", "김냉", "팬트리"), // TODO : 분리
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { idx ->
            onSpaceSelect(idx)
        }
    )
}