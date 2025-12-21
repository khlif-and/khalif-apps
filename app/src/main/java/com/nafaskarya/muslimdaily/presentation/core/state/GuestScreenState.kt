package com.nafaskarya.muslimdaily.presentation.core.state

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@OptIn(ExperimentalMaterial3Api::class)
class GuestScreenState(
    val dimen: WindowDimensions,
    private val density: Density,
    val sheetState: SheetState,
    val interactionSource: MutableInteractionSource,
    private val _isSidebarOpen: MutableState<Boolean>,
    private val _contentTranslationX: State<Float>,
    private val _contentScale: State<Float>
) {
    var showPlayer by mutableStateOf(false)
    var showSleepTimer by mutableStateOf(false)

    var isSidebarOpen: Boolean
        get() = _isSidebarOpen.value
        set(value) { _isSidebarOpen.value = value }

    val contentTranslationX: Float
        get() = _contentTranslationX.value

    val contentScale: Float
        get() = _contentScale.value

    private val headerHeightDp = 210.dp
    private val headerHeightPx = with(density) { headerHeightDp.toPx() }
    val sidebarWidthPx = with(density) { (dimen.width * 0.8f).toPx() }

    var topBarOffsetHeightPx by mutableStateOf(0f)

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if (isSidebarOpen) return Offset.Zero
            val delta = available.y
            val newOffset = topBarOffsetHeightPx + delta
            topBarOffsetHeightPx = newOffset.coerceIn(-headerHeightPx, 0f)
            return Offset.Zero
        }
    }

    val headerAlpha: Float
        get() = (1f + (topBarOffsetHeightPx / headerHeightPx)).coerceIn(0f, 1f)

    val headerHeight: Dp
        get() = headerHeightDp

    fun toggleSidebar() {
        isSidebarOpen = !isSidebarOpen
    }
}