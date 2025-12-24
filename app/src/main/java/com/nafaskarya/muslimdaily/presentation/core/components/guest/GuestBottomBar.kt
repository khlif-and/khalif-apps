package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.clickable
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
    val playerTriggerModifier = remember(state) {
        Modifier.clickable(
            interactionSource = state.interactionSource,
            indication = null,
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