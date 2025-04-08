package com.example.ourfridgeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ourfridgeapp.ui.navigation.BottomNavBar
import com.example.ourfridgeapp.ui.navigation.NavHostScreen
import com.example.ourfridgeapp.ui.navigation.TopAppBarItem
import com.example.ourfridgeapp.ui.theme.OurFridgeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OurFridgeAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBarItem(
                            onClickAddItem = {
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
