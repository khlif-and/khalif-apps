package com.nafaskarya.muslimdaily.presentation.core.components.factory

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberGuestScreenState(
    dimen: WindowDimensions = rememberWindowDimensions(),
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
): GuestScreenState {
    // Kita butuh CoroutineScope untuk operasi async jika nanti diperlukan
    val scope = rememberCoroutineScope()

    return remember(dimen, sheetState, scope) {
        GuestScreenState(
            dimen = dimen,
            sheetState = sheetState,
            scope = scope
        )
    }
}