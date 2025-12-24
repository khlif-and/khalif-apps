package com.nafaskarya.muslimdaily.presentation.core.state

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Dp
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Stable
class GuestScreenState(
    val dimen: WindowDimensions,
    val headerHeight: Dp,
    private val maxHeaderHeightPx: Float,
    val sheetState: SheetState,
    val interactionSource: MutableInteractionSource,
    private val _isSidebarOpen: MutableState<Boolean>,
    private val _contentTranslationX: State<Float>,
    private val _contentScale: State<Float>
) {
    var showPlayer by mutableStateOf(false)
    var showSleepTimer by mutableStateOf(false)

    var topBarOffsetHeightPx by mutableFloatStateOf(0f)

    var isSidebarOpen: Boolean
        get() = _isSidebarOpen.value
        set(value) { _isSidebarOpen.value = value }

    val contentTranslationX: Float
        get() = _contentTranslationX.value

    val contentScale: Float
        get() = _contentScale.value

    val headerAlpha by derivedStateOf {
        val ratio = (maxHeaderHeightPx + topBarOffsetHeightPx) / maxHeaderHeightPx
        ratio.coerceIn(0f, 1f)
    }

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if (isSidebarOpen) return Offset.Zero

            val delta = available.y
            val newOffset = topBarOffsetHeightPx + delta

            topBarOffsetHeightPx = newOffset.coerceIn(-maxHeaderHeightPx, 0f)

            return Offset.Zero
        }
    }

    fun toggleSidebar() {
        isSidebarOpen = !isSidebarOpen
    }
}