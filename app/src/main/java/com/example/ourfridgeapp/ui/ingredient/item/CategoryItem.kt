package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.CategoryType

@Composable
internal fun CategoryItem(
    title: String,
    isChecked: Boolean,
    onClickCategoryItem: (CategoryType) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onClickCategoryItem(CategoryType.fromValueByString(title))
            }
    ) {
        Icon(
            imageVector = Icons.Default.ImageSearch,
            contentDescription = null
        )

        if (title.isNotBlank()) {
            Text(
                text = title,
                style = if (isChecked) FridgeAppTheme.typography.title14 else FridgeAppTheme.typography.body14,
                color = if (isChecked) Color.Red else Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryItem(@PreviewParameter(CategoryParameterProvider::class) title: String) {
    OurFridgeAppTheme {
        CategoryItem(
            title = title,
            isChecked = false,
            onClickCategoryItem = {}
        )
    }
}

private class CategoryParameterProvider(
    override val values: Sequence<String> = sequenceOf(
        titleCase,
        noTitleCase
    )
) : PreviewParameterProvider<String>

private const val titleCase = "우유"
private const val noTitleCase = ""

