package com.example.ourfridgeapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.ourfridgeapp.R
import com.example.ourfridgeapp.util.ScreenType

@Composable
internal fun BottomNavBar(
    navController: NavController
) {
    NavigationBar {
        var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
        val context = LocalContext.current

        navigationItemList.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.titleRes),
                        tint = if(selectedIndex == index) {
                            Color(ContextCompat.getColor(context, R.color.purple_200))
                        }else{
                            Color(ContextCompat.getColor(context, R.color.black))
                        }
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.titleRes),
                        color = if(selectedIndex == index) {
                            Color(ContextCompat.getColor(context, R.color.purple_200))
                        }else{
                            Color(ContextCompat.getColor(context, R.color.black))
                        }
                    )
                },
                selected = selectedIndex == index,
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