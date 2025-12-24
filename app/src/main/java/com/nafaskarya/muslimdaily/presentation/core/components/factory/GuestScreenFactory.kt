package com.nafaskarya.muslimdaily.presentation.core.components.factory

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberGuestScreenState(
    dimen: WindowDimensions = rememberWindowDimensions(),
    density: Density = LocalDensity.current,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
): GuestScreenState {
    val interactionSource = remember { MutableInteractionSource() }
    val isSidebarOpen = remember { mutableStateOf(false) }

    val headerHeight = 210.dp
    val headerHeightPx = with(density) { headerHeight.toPx() }
    val sidebarWidthPx = with(density) { (dimen.width * 0.8f).toPx() }

    val contentTranslationX = animateFloatAsState(
        targetValue = if (isSidebarOpen.value) sidebarWidthPx else 0f,
        animationSpec = spring(stiffness = 800f),
        label = "SidebarAnimation"
    )

    val contentScale = animateFloatAsState(
        targetValue = if (isSidebarOpen.value) 0.92f else 1f,
        animationSpec = spring(stiffness = 800f),
        label = "ContentScale"
    )

    return remember(dimen, density, sheetState, interactionSource, isSidebarOpen, contentTranslationX, contentScale) {
        GuestScreenState(
            dimen = dimen,
            headerHeight = headerHeight,
            maxHeaderHeightPx = headerHeightPx,
            sheetState = sheetState,
            interactionSource = interactionSource,
            _isSidebarOpen = isSidebarOpen,
            _contentTranslationX = contentTranslationX,
            _contentScale = contentScale
        )
    }
}