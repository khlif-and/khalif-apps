package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import kotlin.math.roundToInt

@Composable
fun GuestAnimatedContainer(
    state: GuestScreenState,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset { IntOffset(state.contentTranslationX.roundToInt(), 0) }
            .graphicsLayer {
                scaleX = state.contentScale
                scaleY = state.contentScale
                shape = RoundedCornerShape(if (state.isSidebarOpen) 28.dp else 0.dp)
                clip = state.isSidebarOpen
            }
            .background(ColorConstant.BackgroundDark)
            .nestedScroll(state.nestedScrollConnection)
            .clickable(
                enabled = state.isSidebarOpen,
                interactionSource = state.interactionSource,
                indication = null
            ) { state.isSidebarOpen = false },
        content = content
    )
}