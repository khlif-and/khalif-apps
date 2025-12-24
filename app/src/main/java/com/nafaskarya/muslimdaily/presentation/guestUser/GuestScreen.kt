package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.components.factory.rememberGuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestAnimatedContainer
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBodyContent
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBottomBar
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestStickyHeader
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.ProfileSidebar

private val RootModifier = Modifier
    .fillMaxSize()
    .background(ColorConstant.BackgroundDark)

private val SidebarModifier = Modifier
    .fillMaxWidth(0.8f)
    .fillMaxHeight()
    .graphicsLayer {
        clip = true
        renderEffect = null
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(navController: NavController) {
    val state = rememberGuestScreenState()

    val onDismissPlayer = remember(state) {
        { state.showPlayer = false }
    }

    val onTimerClick = remember(state) {
        { state.showSleepTimer = true }
    }

    val bottomBarContent: @Composable () -> Unit = remember(state) {
        { GuestBottomBar(state) }
    }

    val bodyContent: @Composable (PaddingValues) -> Unit = remember(state, navController) {
        { paddingValues ->
            GuestBodyContent(
                state = state,
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }

    Box(modifier = RootModifier) {
        ProfileSidebar(modifier = SidebarModifier)

        GuestAnimatedContainer(state = state) {
            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = bottomBarContent,
                content = bodyContent
            )

            GuestStickyHeader(state = state)
        }

        if (state.showPlayer) {
            PlayerScreenBottomSheet(
                sheetState = state.sheetState,
                onDismissRequest = onDismissPlayer,
                onTimerClick = onTimerClick
            )
        }
    }
}