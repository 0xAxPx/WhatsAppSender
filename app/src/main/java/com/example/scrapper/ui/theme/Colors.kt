package com.example.scrapper.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Yellow500 = Color(0XFFFFDE03)
val Blue700 = Color(0xFF0036FF)
val Pink500 = Color(0xFFf50057)
val Pink700 = Color(0xFFff5983)
val White = Color(0XFFFFFFFF)

val LightColors = lightColors(
    primary = Yellow500,
    primaryVariant = Blue700,
    secondary = Pink500,
    secondaryVariant = Pink700,
    background = White
)

val DarkColors = darkColors(
    primary = Yellow500,
    primaryVariant = Blue700,
    secondary = Pink700
)