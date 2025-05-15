package com.example.ourfridgeapp.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.ui.theme.Brown
import com.example.ourfridgeapp.ui.theme.FridgeAppTheme
import com.example.ourfridgeapp.ui.theme.Gray
import com.example.ourfridgeapp.ui.theme.Ivory
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.ScreenType

@Composable
internal fun BottomNavBar(
    navController: NavController
) {
    NavigationBar(
        modifier = Modifier
            .navigationBarsPadding()
            .height(56.dp)
            .fillMaxWidth()
    ) {
        var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

        navigationItemList.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_4dp))
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(item.titleRes),
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = stringResource(item.titleRes),
                            style = FridgeAppTheme.typography.body12
                        )
                    }
                },
                label = null,
                selected = selectedIndex == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Brown,
                    unselectedIconColor = Gray,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    selectedIndex = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}