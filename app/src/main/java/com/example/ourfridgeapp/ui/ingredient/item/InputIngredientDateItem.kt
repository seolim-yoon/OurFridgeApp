package com.example.ourfridgeapp.ui.ingredient.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

@Composable
internal fun InputIngredientDateItem(
    title: String,
    onClickDateBtn: () -> Unit
) {
    AddIngredientTitleItem(
        title = title
    ) {
        Text(
            text = "2025.04.08", // TODO : 오늘 날짜
            style = FridgeAppTheme.typography.body16,
            color = Color.Gray
        )
    }
}