package com.example.ourfridgeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ourfridgeapp.ui.fridge.FridgeViewModel
import com.example.ourfridgeapp.ui.ingredient.screen.AddIngredientScreen
import com.example.ourfridgeapp.ui.home.screen.HomeScreen
import com.example.ourfridgeapp.ui.ingredient.IngredientViewModel
import com.example.ourfridgeapp.ui.setting.screen.SettingScreen
import com.example.ourfridgeapp.util.ScreenType

@Composable
internal fun NavHostScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ScreenType.Home,
        modifier = modifier
    ) {
        composable<ScreenType.Home> {
            HomeScreen()
        }

        composable<ScreenType.Fridge> {
//            FridgeScreen()
        }

        composable<ScreenType.Setting> {
            SettingScreen()
        }

        composable<ScreenType.AddIngredient> {
            val viewModel: IngredientViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            AddIngredientScreen(
                state = state,
                onEvent = viewModel::onEvent,
                onClickSave = {

                }
            )
        }
    }
}