package com.nafaskarya.muslimdaily.presentation.core.state

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Stable
class GuestScreenState(
    val dimen: WindowDimensions,
    val sheetState: SheetState,
    val scope: CoroutineScope
) {
    var showPlayer by mutableStateOf(false)
    var showSleepTimer by mutableStateOf(false)
    var showSidebar by mutableStateOf(false)

    fun toggleSidebar() {
        showSidebar = !showSidebar
    }
}

val LocalGuestScreenState = compositionLocalOf<GuestScreenState> {
    error("GuestScreenState not provided")
}