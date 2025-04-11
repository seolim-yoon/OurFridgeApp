package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

            Text(
                text = stringResource(R.string.select_category),
                style = FridgeAppTheme.typography.body14,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        onClickCategoryBtn()
                    }
                    .background(
                        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_8dp)),
                        color = MaterialTheme.colorScheme.primary
                    )
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_6dp),
                        horizontal = dimensionResource(R.dimen.padding_12dp)
                    )
            )

        }
    }
}