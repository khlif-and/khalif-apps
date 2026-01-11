package com.khalifapps.muslimgenz.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.staticCompositionLocalOf

data class Dimens(
    val paddingSmall: Dp = 8.dp,
    val paddingMedium: Dp = 16.dp,
    val paddingLarge: Dp = 24.dp,
    val paddingExtraLarge: Dp = 32.dp,
    val paddingHuge: Dp = 48.dp, // For footers etc
    val spacingHeader: Dp = 56.dp,
    val spacingTopSafe: Dp = 20.dp,
    val spacingBottomSafe: Dp = 50.dp,
    
    val iconSize: Dp = 24.dp,
    val iconSizeLarge: Dp = 28.dp,
    
    val buttonHeight: Dp = 56.dp, // implied by padding vertical 20dp approx or fixed
    val buttonHeightPill: Dp = 60.dp,
    val buttonPaddingVertical: Dp = 20.dp,
    
    val cornerRadiusPill: Int = 50,
    
    val textSizeSmall: TextUnit = 12.sp,
    val textSizeBody: TextUnit = 14.sp,
    val textSizeButton: TextUnit = 16.sp,
    val textSizeTitle: TextUnit = 42.sp,
    
    val lineHeightTitle: TextUnit = 50.sp
)

val CompactDimens = Dimens(
    paddingSmall = 8.dp,
    paddingMedium = 16.dp,
    paddingLarge = 24.dp,
    paddingExtraLarge = 32.dp,
    paddingHuge = 48.dp,
    spacingHeader = 56.dp,
    
    textSizeTitle = 34.sp, // Smaller on phones? Or keep huge? referencing user request for "Agak besar"
    lineHeightTitle = 42.sp
)

// The one user requested (Large)
val MediumDimens = Dimens(
    textSizeTitle = 42.sp,
    lineHeightTitle = 50.sp
)

val ExpandedDimens = Dimens(
    paddingMedium = 24.dp, // More padding on tablets
    paddingLarge = 32.dp,
    spacingHeader = 80.dp,
    textSizeTitle = 56.sp,
    lineHeightTitle = 64.sp
)

val LocalAppDimens = staticCompositionLocalOf { MediumDimens }
