package com.example.ourfridgeapp.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

@Composable
internal fun TitleItem(
    text: String
) {
    Text(
        text = text,
        style = FridgeAppTheme.typography.body14
    )
}