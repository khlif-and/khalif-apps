package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBodyContent
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBottomBar
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.ProfileSidebar

private val RootModifier = Modifier
    .fillMaxSize()
    .background(ColorConstant.BackgroundDark)

private val SidebarModifier = Modifier
    .fillMaxWidth(0.8f) // Lebar sidebar 80% dari layar
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
        // 1. Layer Paling Bawah: KONTEN UTAMA (Scaffold)
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = bottomBarContent,
            content = bodyContent
        )

        // 2. Layer Tengah: SCRIM (Background gelap transparan ketika sidebar muncul)
        // Asumsi: state.showSidebar adalah variable boolean di GuestScreenState
        if (state.showSidebar) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null // Hilangkan efek ripple klik
                    ) {
                        state.toggleSidebar() // Tutup sidebar jika area gelap diklik
                    }
            )
        }

        // 3. Layer Paling Atas: SIDEBAR (Dengan Animasi Slide)
        AnimatedVisibility(
            visible = state.showSidebar,
            enter = slideInHorizontally(initialOffsetX = { -it }), // Masuk dari kiri
            exit = slideOutHorizontally(targetOffsetX = { -it }), // Keluar ke kiri
            modifier = Modifier.align(androidx.compose.ui.Alignment.CenterStart)
        ) {
            ProfileSidebar(modifier = SidebarModifier)
        }

        // 4. Player Bottom Sheet (Overlay paling atas jika aktif)
        if (state.showPlayer) {
            PlayerScreenBottomSheet(
                sheetState = state.sheetState,
                onDismissRequest = onDismissPlayer,
                onTimerClick = onTimerClick
            )
        }
    }
}