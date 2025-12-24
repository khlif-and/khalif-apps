package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState

private val OpenShape = RoundedCornerShape(28.dp)
private val ClosedShape = RoundedCornerShape(0.dp)

@Composable
fun GuestAnimatedContainer(
    state: GuestScreenState,
    content: @Composable BoxScope.() -> Unit
) {
    val onBackdropClick = remember(state) {
        { state.isSidebarOpen = false }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                translationX = state.contentTranslationX
                scaleX = state.contentScale
                scaleY = state.contentScale
                shape = if (state.isSidebarOpen) OpenShape else ClosedShape
                clip = state.isSidebarOpen
            }
            .background(ColorConstant.BackgroundDark)
            .nestedScroll(state.nestedScrollConnection)
            .clickable(
                enabled = state.isSidebarOpen,
                interactionSource = state.interactionSource,
                indication = null,
                onClick = onBackdropClick
            ),
        content = content
    )
}