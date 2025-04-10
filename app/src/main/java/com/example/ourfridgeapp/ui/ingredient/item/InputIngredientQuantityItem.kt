package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.NumberCounter
import com.example.ourfridgeapp.util.NumberCountType

@Composable
internal fun InputIngredientQuantityItem(
    quantity: Int,
    onCountQuantity: (NumberCountType) -> Unit
) {
    AddIngredientTitleItem(
        title = stringResource(R.string.quantity)
    ) {
        NumberCounter(
            value = quantity,
            onChangeCount = { type ->
                onCountQuantity(type)
            },
            range = 0..100
        )
    }
}