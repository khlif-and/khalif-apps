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
    val paddingHuge: Dp = 48.dp,
    val spacingHeader: Dp = 56.dp,
    val spacingTopSafe: Dp = 20.dp,
    val spacingBottomSafe: Dp = 50.dp,

    val iconSizeSmall: Dp = 16.dp,
    val iconSize: Dp = 24.dp,
    val iconSizeLarge: Dp = 28.dp,
    val iconLarge: Dp = 48.dp,
    val iconSizeXLarge: Dp = 32.dp,

    val otpBoxSize: Dp = 60.dp,
    val otpSpacer: Dp = 16.dp,

    val choiceAvatarSize: Dp = 100.dp,
    val choiceGridVerticalSpacing: Dp = 24.dp,
    val choiceGridHorizontalSpacing: Dp = 16.dp,

    val buttonHeight: Dp = 56.dp,
    val buttonHeightPill: Dp = 60.dp,
    val buttonPaddingVertical: Dp = 20.dp,

    val cornerRadiusPill: Int = 50,
    val radiusSmall: Dp = 8.dp,
    val radiusMedium: Dp = 12.dp,
    val radiusLarge: Dp = 16.dp,
    val radiusXLarge: Dp = 24.dp,

    val spacingSmall: Dp = 12.dp,

    val textSizeSmall: TextUnit = 12.sp,
    val textSizeBody: TextUnit = 14.sp,
    val textSizeButton: TextUnit = 16.sp,
    val textSizeMedium: TextUnit = 18.sp,
    val textSizeSection: TextUnit = 20.sp,
    val textSizeTitle: TextUnit = 42.sp,
    val textSizeSubtitle: TextUnit = 28.sp,
    val textSizeArabic: TextUnit = 32.sp,

    val lineHeightTitle: TextUnit = 50.sp,
    val lineHeightSubtitle: TextUnit = 36.sp,
    val lineHeightBody: TextUnit = 26.sp,

    val topBarIconSize: Dp = 48.dp,
    val prayerIconSize: Dp = 32.dp,
    val menuItemIconSize: Dp = 56.dp,
    val menuItemWidth: Dp = 72.dp,
    val menuInnerIconSize: Dp = 28.dp,
    val playButtonSize: Dp = 56.dp,
    val playOverlaySize: Dp = 28.dp,

    val avatarSmall: Dp = 40.dp,

    val greetingCardHeight: Dp = 200.dp,
    val reelCardWidth: Dp = 160.dp,
    val reelCardHeight: Dp = 240.dp,
    val progressBarHeight: Dp = 8.dp,
    val kajianVideoHeight: Dp = 200.dp,
    val discoverCardWidth: Dp = 140.dp,

    val letterSpacingWide: TextUnit = 1.sp,
    val textSizeEmoji: TextUnit = 20.sp,
    val textSizeEmojiSmall: TextUnit = 14.sp,
    val textSizeEmojiXSmall: TextUnit = 10.sp,
    val textSizeReelInfo: TextUnit = 11.sp,

    val glassPadding: Dp = 20.dp,
    val glassInnerPaddingH: Dp = 16.dp,
    val glassInnerPaddingV: Dp = 32.dp,
)

val CompactDimens = Dimens(
    paddingSmall = 6.dp,
    paddingMedium = 12.dp,
    paddingLarge = 20.dp,
    paddingExtraLarge = 28.dp,
    paddingHuge = 40.dp,
    spacingHeader = 48.dp,

    textSizeTitle = 34.sp,
    lineHeightTitle = 42.sp,
    textSizeArabic = 26.sp,
    textSizeSection = 18.sp,
    textSizeMedium = 16.sp,

    topBarIconSize = 40.dp,
    greetingCardHeight = 180.dp,
    reelCardWidth = 140.dp,
    reelCardHeight = 210.dp,
    menuItemIconSize = 48.dp,
    menuItemWidth = 64.dp,
    menuInnerIconSize = 24.dp,
    playButtonSize = 48.dp,
    avatarSmall = 32.dp,
    kajianVideoHeight = 160.dp,
    discoverCardWidth = 120.dp,
)

val MediumDimens = Dimens(
    textSizeTitle = 42.sp,
    lineHeightTitle = 50.sp
)

val ExpandedDimens = Dimens(
    paddingMedium = 24.dp,
    paddingLarge = 32.dp,
    spacingHeader = 80.dp,
    textSizeTitle = 56.sp,
    lineHeightTitle = 64.sp,
    textSizeArabic = 40.sp,
    textSizeSection = 24.sp,

    topBarIconSize = 56.dp,
    greetingCardHeight = 260.dp,
    reelCardWidth = 200.dp,
    reelCardHeight = 300.dp,
    menuItemIconSize = 64.dp,
    menuItemWidth = 84.dp,
    menuInnerIconSize = 32.dp,
    playButtonSize = 64.dp,
    avatarSmall = 48.dp,
    kajianVideoHeight = 280.dp,
    discoverCardWidth = 180.dp,
)

val LocalAppDimens = staticCompositionLocalOf { MediumDimens }
