package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.runtime.Composable
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem
import com.example.ourfridgeapp.util.SpaceType

@Composable
internal fun InputIngredientSpaceItem(
    selectedTabIndex: Int,
    onSpaceSelect: (Int) -> Unit
) {
    val tabList = SpaceType.entries.map { it.title }
    SpaceTabRowItem(
        tabs = tabList,
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { idx ->
            onSpaceSelect(idx)
        }
    )
}