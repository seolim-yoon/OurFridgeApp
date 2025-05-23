package com.example.ourfridgeapp.ui.fridge.item

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.Beige
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.ui.theme.Red
import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.DateViewType
import com.example.ourfridgeapp.util.SpaceType
import com.example.ourfridgeapp.util.toLocalDateTime

@Composable
internal fun FridgeItem(
    ingredient: IngredientUiModel,
    onClickIngredientItem: (IngredientUiModel) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp)),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickIngredientItem(ingredient)
            }
            .clip(
                shape = RoundedCornerShape(dimensionResource(R.dimen.radius_12dp))
            )
            .background(
                color = Beige
            )
            .padding(dimensionResource(R.dimen.padding_12dp))
    ) {
        IngredientTopItem(
            viewType = ingredient.dateViewType,
            dDay = ingredient.dDay,
            name = ingredient.name,
            categoryImage = ingredient.category.imageRes,
            count = ingredient.quantity
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
        ) {
            IngredientBottomItem(
                title = stringResource(R.string.purchase_date),
                date = ingredient.purchaseDate.toLocalDateTime().toLocalDate().toString()
            )

            IngredientBottomItem(
                title = stringResource(R.string.expired_date),
                date = ingredient.expirationDate.toLocalDateTime().toLocalDate().toString()
            )
        }
    }
}

@Composable
internal fun IngredientTopItem(
    viewType: DateViewType,
    dDay: Int,
    name: String,
    categoryImage: Int,
    count: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(categoryImage),
                contentDescription = null,
                modifier = Modifier.size(40.dp, 40.dp)
            )
        }

        val stringRes = if (viewType == DateViewType.REMAINING) R.string.d_day else R.string.elapsed_day
        Text(
            text = if (dDay == 0) stringResource(R.string.d_day_expired
            ) else stringResource(stringRes, dDay),
            style = FridgeAppTheme.typography.title18,
            color = Red
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            style = FridgeAppTheme.typography.title16
        )
        Text(
            text = stringResource(R.string.ingredient_count, count),
            style = FridgeAppTheme.typography.body16
        )
    }
}

@Composable
internal fun IngredientBottomItem(
    title: String,
    date: String
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
    ) {
        Text(
            text = title,
            style = FridgeAppTheme.typography.body14
        )
        Text(
            text = date,
            style = FridgeAppTheme.typography.body14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIngredientItem() {
    OurFridgeAppTheme {
        FridgeItem(
            ingredient = IngredientUiModel(
                id = 0,
                space = SpaceType.FRIDGE,
                category = CategoryType.DEFAULT,
                name = "애호박",
                quantity = 2,
                purchaseDate = 1231312L,
                expirationDate = 123123L,
                dDay = 9,
                memo = ""
            ),
            onClickIngredientItem = {}
        )
    }
}