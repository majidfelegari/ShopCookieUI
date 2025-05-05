package com.example.shopcookieui.ui.theme

import androidx.compose.ui.graphics.painter.Painter

data class CookiesData(
    val image: Painter,
    val name: String,
    val normalPrice : String? = null,
    val currentPrice : String
)
