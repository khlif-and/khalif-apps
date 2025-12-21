package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.shared.footer.BottomNav
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerFooter

@Composable
fun GuestBottomBar(state: GuestScreenState) {
    Column {
        Box(
            modifier = Modifier.clickable(
                interactionSource = state.interactionSource,
                indication = null
            ) { state.showPlayer = true }
        ) {
            PlayerFooter()
        }
        BottomNav()
    }
}