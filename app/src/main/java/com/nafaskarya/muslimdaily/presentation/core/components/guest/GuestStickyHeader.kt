package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import kotlin.math.roundToInt

@Composable
fun GuestStickyHeader(
    state: GuestScreenState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorConstant.BackgroundDark)
                .statusBarsPadding()
        )

        Box(
            modifier = Modifier
                .offset { IntOffset(x = 0, y = state.topBarOffsetHeightPx.roundToInt()) }
                .graphicsLayer { alpha = state.headerAlpha }
                .background(ColorConstant.BackgroundDark)
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Column(modifier = Modifier.padding(bottom = 12.dp)) {
                GuestHeaderSection(state.dimen) { state.toggleSidebar() }
                GuestCategorySection(state.dimen)
            }
        }
    }
}