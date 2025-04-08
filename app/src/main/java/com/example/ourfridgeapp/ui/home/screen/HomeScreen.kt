package com.example.ourfridgeapp.ui.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R

@Composable
internal fun HomeScreen() {
    Box {
        Text(
            text = stringResource(R.string.screen_home)
        )
    }
}