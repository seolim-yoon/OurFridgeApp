package com.example.ourfridgeapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun ButtonItem(
    text: String,
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClickButton,
        modifier = modifier.fillMaxWidth()
    ) {
        TitleItem(
            text = text
        )
    }
}