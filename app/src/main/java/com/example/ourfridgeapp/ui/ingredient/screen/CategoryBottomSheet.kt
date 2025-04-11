package com.example.ourfridgeapp.ui.ingredient.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.ingredient.item.CategoryItem
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.CATEGORY_ITEM_TYPE
import com.example.ourfridgeapp.util.CategoryType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CategoryBottomSheet(
    currentCategory: CategoryType,
    onClickCategoryItem: (CategoryType) -> Unit,
    onDismissRequest: () -> Unit,
) {
    val bottomState = rememberModalBottomSheetState(

    )

    ModalBottomSheet(
        containerColor = Color.White,
        sheetState = bottomState,
        onDismissRequest = onDismissRequest
    ) {
        CategoryBottomSheetItem(
            currentCategory = currentCategory,
            onClickCategoryItem = onClickCategoryItem
        )
    }
}

@Composable
internal fun CategoryBottomSheetItem(
    currentCategory: CategoryType,
    onClickCategoryItem: (CategoryType) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8dp)),
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = dimensionResource(R.dimen.padding_40dp))
    ) {
        Text(
            text = stringResource(R.string.select_category),
            style = FridgeAppTheme.typography.title18,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_20dp)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_16dp)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp)),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                key = { it.id },
                contentType = { CATEGORY_ITEM_TYPE },
                items = CategoryType.entries.toTypedArray().drop(1)
            ) { category ->
                CategoryItem(
                    title = category.title,
                    isChecked = currentCategory == category,
                    onClickCategoryItem = onClickCategoryItem

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryBottomSheetItem() {
    OurFridgeAppTheme {
        CategoryBottomSheetItem(
            currentCategory = CategoryType.CAN,
            onClickCategoryItem = {}
        )
    }
}
