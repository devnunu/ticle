package com.devnunu.ticle.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.core.ui.R

val fonts = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, weight = FontWeight.Bold),
    Font(R.font.spoqa_han_sans_neo_medium, weight = FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_regular, weight = FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_light, weight = FontWeight.Light),
)

val Bold30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 43.5.sp,
        color = black
    )

val Medium30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 30.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 43.5.sp,
        color = black
    )

val Regular30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 43.5.sp,
        color = black
    )

val Light30: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 30.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 43.5.sp,
        color = black
    )

val Bold27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 27.sp ,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 39.15.sp ,
        color = black
    )

val Medium27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 27.sp ,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 39.15.sp ,
        color = black
    )

val Regular27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 27.sp ,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 39.15.sp ,
        color = black
    )

val Light27: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 27.sp ,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 39.15.sp ,
        color = black
    )

val Bold25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 36.25.sp ,
        color = black
    )

val Medium25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 36.25.sp ,
        color = black
    )

val Regular25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 36.25.sp ,
        color = black
    )

val Light25: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 36.25.sp ,
        color = black
    )

val Bold24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 34.8.sp ,
        color = black
    )

val Medium24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 34.8.sp ,
        color = black
    )

val Regular24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 34.8.sp ,
        color = black
    )

val Light24: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 34.8.sp ,
        color = black
    )

val Bold22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 31.9.sp ,
        color = black
    )

val Medium22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 31.9.sp ,
        color = black
    )

val Regular22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 31.9.sp ,
        color = black
    )

val Light22: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 31.9.sp ,
        color = black
    )

val Bold20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 29.sp ,
        color = black
    )

val Medium20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 29.sp ,
        color = black
    )

val Regular20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 29.sp ,
        color = black
    )

val Light20: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.01).sp,
        lineHeight = 29.sp ,
        color = black
    )

val Bold18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 26.1.sp ,
        color = black
    )

val Medium18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 26.1.sp ,
        color = black
    )

val Regular18: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 26.1.sp ,
        color = black
    )

val Bold16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 23.2.sp ,
        color = black
    )

val Medium16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 23.2.sp ,
        color = black
    )

val Regular16: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 23.2.sp ,
        color = black
    )

val Bold15: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 21.75.sp ,
        color = black
    )

val Medium15: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 21.75.sp ,
        color = black
    )

val Regular15: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 21.75.sp ,
        color = black
    )

val Bold14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 20.3.sp ,
        color = black
    )

val Medium14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 20.3.sp ,
        color = black
    )

val Regular14: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 20.3.sp ,
        color = black
    )

val Bold13: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 18.85.sp ,
        color = black
    )

val Medium13: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 18.85.sp ,
        color = black
    )

val Regular13: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 18.85.sp ,
        color = black
    )

val Bold12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 17.4.sp ,
        color = black
    )

val Medium12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 17.4.sp ,
        color = black
    )

val Regular12: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 17.4.sp ,
        color = black
    )

val Bold11: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 15.95.sp ,
        color = black
    )

val Medium11: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 15.95.sp ,
        color = black
    )

val Regular11: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 15.95.sp ,
        color = black
    )

val Bold10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.01).sp,
        lineHeight = 14.5.sp ,
        color = black
    )

val Medium10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.01).sp,
        lineHeight = 14.5.sp ,
        color = black
    )

val Regular10: TextStyle
    @Composable get() = TextStyle(
        fontFamily = fonts,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.01).sp,
        lineHeight = 14.5.sp ,
        color = black
    )