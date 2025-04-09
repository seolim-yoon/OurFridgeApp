package com.example.ourfridgeapp.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopAppBarItem(
    isBackNav: Boolean = false,
    isVisibleAddBtn: Boolean = false,
    topBarTitle: String,
    onClickBackNav: () -> Unit = {},
    onClickAddItem: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = topBarTitle,
                modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_16dp)),
                style = FridgeAppTheme.typography.title20
            )
        },
        navigationIcon = {
            if (isBackNav) {
                IconButton(
                    onClick = onClickBackNav
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        },
        actions = {
            if (isVisibleAddBtn) {
                Text(
                    text = stringResource(R.string.add_ingredient),
                    style = FridgeAppTheme.typography.title14,
                    modifier = Modifier
                        .clickable {
                            onClickAddItem()
                        }
                        .padding(dimensionResource(R.dimen.padding_12dp))
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarItem() {
    OurFridgeAppTheme {
        TopAppBarItem(
            isBackNav = true,
            isVisibleAddBtn = true,
            topBarTitle = "TopBar",
            onClickBackNav = {},
            onClickAddItem = {}
        )
    }
}