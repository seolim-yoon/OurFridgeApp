package com.example.ourfridgeapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun ButtonItem(
    text: String,
    onClickButton: () -> Unit
) {
    Button(
        onClick = onClickButton,
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleItem(
            text = text
        )
    }
}