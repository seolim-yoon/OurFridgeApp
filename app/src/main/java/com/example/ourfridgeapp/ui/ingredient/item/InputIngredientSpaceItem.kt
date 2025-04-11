package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.fridge.item.SpaceTabRowItem

@Composable
internal fun InputIngredientSpaceItem(
    onSpaceSelect: (Int) -> Unit
) {
    SpaceTabRowItem(
        tabs = listOf("냉장", "냉동", "김치냉장고"),
        selectedTabIndex = 0,
        onTabSelected = onSpaceSelect,
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_8dp))
    )
}