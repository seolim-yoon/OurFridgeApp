package com.example.ourfridgeapp.ui.setting.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.common.TitleItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.SETTING_ITEM_TYPE
import com.example.ourfridgeapp.util.Settings

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SettingScreen() {
    val listState = rememberLazyListState()
    var switch by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalOverscrollConfiguration provides null)  {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_24dp)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_24dp)),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                key = { it.ordinal },
                contentType = { SETTING_ITEM_TYPE },
                items = Settings.entries
            ) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp, 25.dp)
                    )
                    TitleItem(
                        text = stringResource(item.title),
                        modifier = Modifier.weight(1f)
                            .padding(start = dimensionResource(R.dimen.padding_12dp))
                    )

                    if (item.hasCheckOption) {
                        Switch(
                            checked = switch,
                            onCheckedChange = { isChecked ->
                                switch = isChecked
                            },
                            modifier = Modifier.height(20.dp)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSettingScreen() {
    OurFridgeAppTheme {
        SettingScreen()
    }
}