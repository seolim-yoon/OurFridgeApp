package com.example.ourfridgeapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


/*
* primary = 탭바 글자, 버튼 기본색, 라디오버튼
* secondary =
* tertiary =
* surface = topbar, bottomnav 배경, 탭바 배경
* surfaceVariant = 선택안된 라디오버튼
*
*
*
*
* */
private val DarkColorScheme = darkColorScheme(
    primary = Brown,
    secondary = Beige,
    tertiary = Color.Red,
    background = Black,
    onBackground = Ivory,
//    surface = Brown,
)

private val LightColorScheme = lightColorScheme(
    primary = Brown,
    secondary = Beige,
    tertiary = Color.Red,
    background = Ivory,
    onBackground = Black,
    surface = Beige


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun OurFridgeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = LightColorScheme
//        when {
//        darkTheme -> DarkColorScheme
//        else ->
//    }

    CompositionLocalProvider(
        LocalFridgeTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

object FridgeAppTheme {
    val typography: FridgeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalFridgeTypography.current
}