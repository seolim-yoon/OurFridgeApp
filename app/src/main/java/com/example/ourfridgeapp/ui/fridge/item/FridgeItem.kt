package com.example.ourfridgeapp.ui.fridge.item

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.CategoryType
import com.example.ourfridgeapp.util.SpaceType

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
                color = Color.LightGray
            )
            .padding(dimensionResource(R.dimen.padding_12dp))
    ) {
        IngredientTopItem(
            dDay = ingredient.dDay,
            name = ingredient.name,
            count = ingredient.quantity
        )

        IngredientBottomItem(
            purchaseDate = ingredient.purchaseDate,
            expirationDate = ingredient.expirationDate
        )
    }
}

@Composable
internal fun IngredientTopItem(
    dDay: Int,
    name: String,
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
            Icon(
                imageVector = Icons.Default.Face, // TODO : 카테고리 아이콘
                contentDescription = null
            )
        }

        Text(
            text = stringResource(R.string.d_day, dDay),
            style = FridgeAppTheme.typography.title16,
            color = Color.Red // TODO : 주황빛으로
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_2dp)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            style = FridgeAppTheme.typography.title14
        )
        Text(
            text = stringResource(R.string.ingredient_count, count),
            style = FridgeAppTheme.typography.body14
        )
    }
}

@Composable
internal fun IngredientBottomItem(
    purchaseDate: String,
    expirationDate: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
    ) {
        Text(
            text = stringResource(R.string.purchase_date, purchaseDate),
            style = FridgeAppTheme.typography.body12
        )
        Text(
            text = stringResource(R.string.expired_date, expirationDate),
            style = FridgeAppTheme.typography.body12
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
                purchaseDate = "2025.04.01",
                expirationDate = "2025.04.16",
                dDay = 9,
                memo = ""
            ),
            onClickIngredientItem = {}
        )
    }
}