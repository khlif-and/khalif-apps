package com.nafaskarya.muslimdaily.presentation.core.constant

import androidx.compose.ui.graphics.Color

object ColorConstant {
    val GreenPrimary = Color(0xFF4CAF50)
    val TextWhite = Color(0xFFFFFFFF)
    val TextGray = Color(0xFFBDBDBD)
    val BorderColor = Color(0xFF767676)

    val BackgroundDark = Color(0xFF121212)
    val SurfaceDark = Color(0xFF2C2C2C)
    val AccentOrange = Color(0xFFC67C4E)

    val PlayerScreenBackground = Color(0xFF581313)
    val PlayerFooterBackground = Color(0xFF5D3A15)
    val PlayerTextSecondary = Color(0xFFD7CCC8)
    val PlayerIconColor = Color.White
    val PlayerAccentGreen = Color(0xFF1DB954)

    val ShareScreenBackground = Color(0xFF1E1611)
    val ShareSurfaceColor = Color(0xFF3E3E3E)
    val ShareCardBrown = Color(0xFF4E342E)
    val ShareCardGold = Color(0xFFD4A056)
    val ShareCardWhite = Color(0xFFFFFFFF)
    val ShareCardBlack = Color(0xFF000000)
    val ShareCardTeal = Color(0xFF004D40)
    val ShareCardBlue = Color(0xFF0D47A1)
    val ShareCardRed = Color(0xFFD32F2F)

    val ShareCardColors = listOf(
        ShareCardBrown, ShareCardGold, ShareCardWhite, ShareCardBlack,
        ShareCardTeal, ShareCardBlue, ShareCardRed
    )

    val MoreMenuSheetBackground = Color(0xFF1F1F1F)
    val MoreMenuButtonBackground = Color(0xFF333333)
    val MoreMenuSeparatorColor = Color(0xFF2C2C2C)

    val ProfileBackground = Color(0xFF121212)
    val ProfileSurface = Color(0xFF1F1F1F)
    val ProfileRedDanger = Color(0xFFEF5350)

    // --- TAMBAHAN WARNA CATEGORY ---
    val CatOrange = Color(0xFFFF6F00)
    val CatPurple = Color(0xFF7B1FA2)
    val CatBlue = Color(0xFF1976D2)
    val CatTeal = Color(0xFF00796B)
    val CatPink = Color(0xFFC2185B)

    // List warna yang akan di-cycle
    val CategoryColors = listOf(
        CatOrange,
        CatPurple,
        CatBlue,
        CatTeal,
        CatPink,
        GreenPrimary
    )
}