package com.jeffg.dev.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jeffg.dev.littlelemon.R

val karla = FontFamily(Font(R.font.karla_regular))
val markazi = FontFamily(Font(R.font.markazi_text_regular))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = markazi,
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.yellow
    ),
    h2 = TextStyle(
        fontFamily = markazi,
        color = LittleLemonColor.cloud,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    ),
    h3 = TextStyle(
        fontFamily = karla,
        color = LittleLemonColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    h4 = TextStyle(
        fontFamily = markazi,
        color = LittleLemonColor.charcoal,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        fontFamily = karla,
        color = LittleLemonColor.green,
        fontSize = 16.sp,
    ),
    body2 = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.green,
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = karla,
        color = LittleLemonColor.charcoal,
        fontSize = 14.sp,
    ),
    button = TextStyle(
        fontFamily = karla,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
)
