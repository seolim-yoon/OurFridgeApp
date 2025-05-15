package com.example.ourfridgeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.ourfridgeapp.ui.navigation.BottomNavBar
import com.example.ourfridgeapp.ui.navigation.NavHostScreen
import com.example.ourfridgeapp.ui.navigation.TopAppBarItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme
import com.example.ourfridgeapp.util.ScreenType
import com.example.ourfridgeapp.util.TopBarByScreenType
import com.example.ourfridgeapp.util.notification.NotificationAlarmManager.createChannel
import com.example.ourfridgeapp.util.notification.ScheduledWorker
import com.example.ourfridgeapp.util.notification.TimeRequest
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createChannel(
            context = applicationContext,
            channelId = "channelId",
            channelName = "channelName",
            descriptionText = "descriptionText"
        )
        initWorkManager()
        setContent {
            OurFridgeAppTheme {
                val navController = rememberNavController()
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route?.split(".")?.last() ?: ""
                val currentScreenType = TopBarByScreenType.getScreenType(currentRoute)

                val snackBarHostState = remember { SnackbarHostState() }

                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                    topBar = {
                        TopAppBarItem(
                            isBackNav = currentScreenType.isBackNavButton,
                            isVisibleAddBtn = currentScreenType.isVisibleAddButton,
                            topBarTitle = stringResource(currentScreenType.topBarTitleRes),
                            onClickBackNav = {
                                navController.popBackStack()
                            },
                            onClickAddItem = {
                                navController.navigate(
                                    route = ScreenType.AddIngredient()
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
                        snackBarHostState = snackBarHostState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun initWorkManager() {
        val dailyWorkRequest = OneTimeWorkRequestBuilder<ScheduledWorker>()
//            .setInitialDelay(TimeRequest.getTimeUsingInWorkRequest(), TimeUnit.MILLISECONDS)
            .addTag("notify_day_by_day")
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(dailyWorkRequest)
    }
}
