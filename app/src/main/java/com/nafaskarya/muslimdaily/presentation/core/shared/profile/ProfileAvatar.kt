package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.state.LocalGuestScreenState

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier
) {
    val state = LocalGuestScreenState.current

    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(ColorConstant.TextGray)
            .clickable { state.toggleSidebar() }
    )
}