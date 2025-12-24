package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nafaskarya.muslimdaily.presentation.core.shared.footer.BottomNav
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerFooter
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState

@Composable
fun GuestBottomBar(state: GuestScreenState) {
    // Kita buat interactionSource lokal di sini karena sudah dihapus dari State
    val interactionSource = remember { MutableInteractionSource() }

    val playerTriggerModifier = remember(state, interactionSource) {
        Modifier.clickable(
            interactionSource = interactionSource,
            indication = null, // Menghilangkan efek ripple saat diklik
            onClick = { state.showPlayer = true }
        )
    }

    Column {
        Box(modifier = playerTriggerModifier) {
            PlayerFooter()
        }
        BottomNav()
    }
}