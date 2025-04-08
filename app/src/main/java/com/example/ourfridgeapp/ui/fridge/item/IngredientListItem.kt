package com.example.ourfridgeapp.ui.fridge.item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.fridge.uimodel.IngredientUiModel
import com.example.ourfridgeapp.util.FRIDGE_ITEM_TYPE

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun IngredientListItem(
    ingredients: List<IngredientUiModel>
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null)  {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_16dp)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp)),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                key = { it.id },
                contentType = { FRIDGE_ITEM_TYPE },
                items = ingredients
            ) { ingredient ->
                IngredientItem(
                    ingredient = ingredient
                )
            }
        }
    }
}