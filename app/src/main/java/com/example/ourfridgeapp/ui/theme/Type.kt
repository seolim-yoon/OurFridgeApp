package com.example.ourfridgeapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Immutable
data class FridgeTypography(
    val title20: TextStyle = TextStyle.Default,
    val title18: TextStyle = TextStyle.Default,
    val title16: TextStyle = TextStyle.Default,
    val title14: TextStyle = TextStyle.Default,
    val body16: TextStyle = TextStyle.Default,
    val body14: TextStyle = TextStyle.Default,
    val body12: TextStyle = TextStyle.Default
)

val Typography = FridgeTypography(

    title20 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp
    ),
    title18 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp
    ),
    title16 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 22.sp
    ),
    title14 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp
    ),
    body16 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp
    ),
    body14 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),
    body12 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp
    )
)

val LocalFridgeTypography = staticCompositionLocalOf {
    FridgeTypography()
}