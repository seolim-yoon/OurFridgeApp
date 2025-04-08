package com.example.ourfridgeapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_16dp)),
                style = FridgeAppTheme.typography.title20
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBar() {
    OurFridgeAppTheme {
        TopAppBar()
    }
}