package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState

// File ini sebenarnya sudah tidak dipakai di GuestScreen.kt yang baru.
// Kamu bisa menghapus file ini.

@Composable
fun GuestAnimatedContainer(
    state: GuestScreenState,
    content: @Composable BoxScope.() -> Unit
) {
    Box(content = content)
}