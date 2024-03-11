package com.scrollz.testvk.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.scrollz.testvk.R

val NunitoFamily = FontFamily(
    Font(R.font.nunito_extrabold, FontWeight.ExtraBold),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_medium, FontWeight.Medium),
    Font(R.font.nunito_regular, FontWeight.Normal),
    Font(R.font.nunito_light, FontWeight.Light)
)

val Typography = Typography(
    // Label
    headlineMedium = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 20.sp
    ),
    // Price
    titleLarge = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 18.sp
    ),
    // Title
    titleMedium = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 16.sp
    ),
    // Brand
    titleSmall = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 11.sp,
        lineHeight = 11.sp
    ),
    // Rating
    labelMedium = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 12.sp
    ),
    // Description
    labelSmall = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 12.sp
    ),
    // Search
    displayMedium = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 15.sp
    ),
    // Button
    displaySmall = TextStyle(
        fontFamily = NunitoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 14.sp
    )
)
