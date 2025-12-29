package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState

private val HeaderBackgroundModifier = Modifier
    .fillMaxWidth()
    .background(ColorConstant.BackgroundDark)
    .statusBarsPadding()

private val ContentPaddingModifier = Modifier.padding(bottom = 12.dp)

@Composable
fun GuestStickyHeader(
    state: GuestScreenState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Box(modifier = HeaderBackgroundModifier) {
            Column(modifier = ContentPaddingModifier) {
                GuestHeaderSection(
                    dimen = state.dimen
                )
            }
        }
    }
}