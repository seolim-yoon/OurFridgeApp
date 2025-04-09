package com.example.ourfridgeapp.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

@Composable
internal fun PlaceHolderItem(
    placeHolder: String
) {
    Text(
        text = placeHolder,
        style = FridgeAppTheme.typography.title16,
        color = Color.Gray
    ) // TODO : 가운데 정렬
}