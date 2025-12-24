package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState

// 1. Static Modifier untuk background agar tidak dibuat ulang
private val HeaderBackgroundModifier = Modifier
    .fillMaxWidth()
    .background(ColorConstant.BackgroundDark)
    .statusBarsPadding()

private val ContentPaddingModifier = Modifier.padding(bottom = 12.dp)

@Composable
fun GuestStickyHeader(
    state: GuestScreenState,
    modifier: Modifier = Modifier
) {
    // 2. Memoize callback
    val onProfileClick = remember(state) {
        { state.toggleSidebar() }
    }

    Box(modifier = modifier.fillMaxWidth()) {
        // Placeholder background (Static)
        Box(modifier = HeaderBackgroundModifier)

        // Animated Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorConstant.BackgroundDark) // Background warna
                .statusBarsPadding() // Padding status bar
                .graphicsLayer {
                    // KUNCI OPTIMASI DISINI:
                    // Membaca state di dalam block graphicsLayer menunda pembacaan ke fase DRAW (GPU).
                    // Compose TIDAK akan melakukan recomposition atau relayout, hanya redraw pixels.

                    translationY = state.topBarOffsetHeightPx // Ganti offset dengan translationY
                    alpha = state.headerAlpha

                    // Optimization: Kalau alpha 0 (invisible), skip drawing
                    val isVisible = alpha > 0f
                    if (!isVisible) {
                        // Trik agar GPU skip render layer ini kalau transparan total
                        scaleX = 0f
                        scaleY = 0f
                    } else {
                        scaleX = 1f
                        scaleY = 1f
                    }
                }
        ) {
            Column(modifier = ContentPaddingModifier) {
                GuestHeaderSection(
                    dimen = state.dimen,
                    onProfileClick = onProfileClick
                )
                GuestCategorySection(dimen = state.dimen)
            }
        }
    }
}