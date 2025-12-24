package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestDiscoveryPart
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestMainContentPart

private val FillMaxSizeModifier = Modifier.fillMaxSize()

@Composable
fun GuestBodyContent(
    state: GuestScreenState,
    navController: NavController,
    paddingValues: PaddingValues
) {
    val topPadding = paddingValues.calculateTopPadding()

    val listContentPadding = remember(topPadding) {
        PaddingValues(
            top = topPadding,
            bottom = 120.dp
        )
    }

    val onShowPlayer = remember(state) {
        { state.showPlayer = true }
    }

    LazyColumn(
        modifier = FillMaxSizeModifier,
        contentPadding = listContentPadding
    ) {
        // Spacer adalah Composable biasa, jadi WAJIB pakai item { }
        item(
            key = "header_spacer",
            contentType = "spacer"
        ) {
            Spacer(modifier = Modifier.height(state.headerHeight))
        }

        // guestMainContentPart adalah LazyListScope extension.
        // JANGAN dibungkus item { }, panggil langsung.
        guestMainContentPart(
            dimen = state.dimen,
            onPlayClick = onShowPlayer
        )

        // guestDiscoveryPart juga LazyListScope extension.
        // JANGAN dibungkus item { }, panggil langsung.
        guestDiscoveryPart(
            dimen = state.dimen,
            navController = navController
        )
    }
}