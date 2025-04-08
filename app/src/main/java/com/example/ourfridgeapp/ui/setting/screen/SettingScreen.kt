package com.example.ourfridgeapp.ui.setting.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ourfridgeapp.R

@Composable
internal fun SettingScreen() {
    Box {
        Text(
            text = stringResource(R.string.screen_setting)
        )
    }


}