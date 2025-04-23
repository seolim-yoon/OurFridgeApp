package com.example.ourfridgeapp.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme

@Composable
internal fun TitleItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = FridgeAppTheme.typography.title16,
        modifier = modifier
    )
}