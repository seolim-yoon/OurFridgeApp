package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.TitleItem

@Composable
internal fun InputIngredientCategoryItem(
    onClickCategoryBtn:() -> Unit
) {
    AddIngredientTitleItem(
        title = stringResource(R.string.category)
    ) {
        Button(
            onClick = onClickCategoryBtn
        ) {
            TitleItem(
                text = stringResource(R.string.select_category)
            )
        }
    }
}