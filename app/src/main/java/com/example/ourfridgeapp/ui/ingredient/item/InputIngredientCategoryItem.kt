package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.util.CategoryType

@Composable
internal fun InputIngredientCategoryItem(
    currentCategory: CategoryType,
    onClickCategoryBtn:() -> Unit
) {
    AddIngredientTitleItem(
        title = stringResource(R.string.category)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp))
        ) {

            if (currentCategory != CategoryType.DEFAULT) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )

                Text(
                    text = currentCategory.title,
                    style = FridgeAppTheme.typography.body16
                )
            }

            Button(
                onClick = onClickCategoryBtn
            ) {
                Text(
                    text = stringResource(R.string.select_category),
                    style = FridgeAppTheme.typography.body16
                )
            }
        }
    }
}