package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.RadioButtonItem
import com.example.ourfridgeapp.util.DateViewType

@Composable
internal fun InputIngredientViewTypeItem(
    selectedViewType: DateViewType,
    onSelectedType: (DateViewType) -> Unit
) {
    AddIngredientTitleItem(
        title = stringResource(R.string.view_type)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
        ) {
            DateViewType.entries.forEach { type ->
                RadioButtonItem(
                    viewType = type,
                    isChecked = selectedViewType == type,
                    onSelectedType = onSelectedType
                )
            }
        }
    }
}
