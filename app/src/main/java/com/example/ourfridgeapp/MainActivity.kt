package com.example.ourfridgeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ourfridgeapp.ui.navigation.BottomNavBar
import com.example.ourfridgeapp.ui.navigation.NavHostScreen
import com.example.ourfridgeapp.ui.navigation.TopAppBarItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.ScreenType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OurFridgeAppTheme {
                val navController = rememberNavController()
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

                Scaffold(
                    topBar = {
                        TopAppBarItem(
                            isBackNav = currentRoute.contains(ScreenType.AddIngredient.toString()),
                            isVisibleAddBtn = currentRoute.contains(ScreenType.Fridge.toString()),
                            topBarTitle = if (currentRoute.contains(ScreenType.Home.toString()))
                                stringResource(R.string.app_name)
                            else if (currentRoute.contains(ScreenType.Fridge.toString()))
                                stringResource(R.string.screen_fridge)
                            else if (currentRoute.contains(ScreenType.AddIngredient.toString()))
                                stringResource(R.string.add_ingredient)
                            else
                                stringResource(R.string.screen_setting), // TODO : sealed class 내에서 가져오도록 구조 수정
                            onClickBackNav = {
                                navController.popBackStack()
                            },
                            onClickAddItem = {
                                navController.navigate(
                                    route = ScreenType.AddIngredient
                                )
                            }
                        )
                    },
                    bottomBar = {
                        BottomNavBar(
                            navController = navController
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHostScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
