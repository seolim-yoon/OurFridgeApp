package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.TitleItem

@Composable
internal fun AddIngredientTitleItem(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
    ) {
        TitleItem(
            text = title
        )

       content()
    }
}