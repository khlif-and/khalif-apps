package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.components.factory.rememberGuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.ProfileSidebar
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestAnimatedContainer
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBodyContent
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBottomBar
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestStickyHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(navController: NavController) {
    val state = rememberGuestScreenState()

    Box(modifier = Modifier.fillMaxSize().background(ColorConstant.BackgroundDark)) {

        ProfileSidebar(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight())

        GuestAnimatedContainer(state = state) {
            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = { GuestBottomBar(state) }
            ) { paddingValues ->
                GuestBodyContent(
                    state = state,
                    navController = navController,
                    paddingValues = paddingValues
                )
            }

            GuestStickyHeader(state = state)
        }

        if (state.showPlayer) {
            PlayerScreenBottomSheet(
                sheetState = state.sheetState,
                onDismissRequest = { state.showPlayer = false },
                onTimerClick = { state.showSleepTimer = true }
            )
        }
    }
}