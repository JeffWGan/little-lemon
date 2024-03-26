package com.jeffg.dev.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    h1 = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.charcoal
    ),
    h2 = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    h3 = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    h4 = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        color = LittleLemonColor.green,
        fontSize = 16.sp,
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.green
    ),
    subtitle1 = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 14.sp,
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
)
