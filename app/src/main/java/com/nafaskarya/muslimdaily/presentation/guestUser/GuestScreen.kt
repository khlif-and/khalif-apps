package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nafaskarya.muslimdaily.presentation.core.components.factory.rememberGuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBottomBar
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.ProfileSidebar
import com.nafaskarya.muslimdaily.presentation.core.state.LocalGuestScreenState
import com.nafaskarya.muslimdaily.presentation.guestUser.navigation.GuestNavGraph

private val RootModifier = Modifier
    .fillMaxSize()
    .background(ColorConstant.BackgroundDark)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(rootNavController: NavController) {
    val state = rememberGuestScreenState()
    val bottomNavController = rememberNavController()

    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    val onDismissPlayer = remember(state) {
        { state.showPlayer = false }
    }

    val onTimerClick = remember(state) {
        { state.showSleepTimer = true }
    }

    val onBottomNavClick: (String) -> Unit = remember(bottomNavController) {
        { route ->
            bottomNavController.navigate(route) {
                popUpTo(bottomNavController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    CompositionLocalProvider(LocalGuestScreenState provides state) {
        Box(modifier = RootModifier) {
            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = {
                    GuestBottomBar(
                        state = state,
                        currentRoute = currentRoute,
                        onNavigate = onBottomNavClick
                    )
                },
                content = { paddingValues ->
                    GuestNavGraph(
                        bottomNavController = bottomNavController,
                        rootNavController = rootNavController,
                        state = state,
                        paddingValues = paddingValues
                    )
                }
            )

            // BERSIH: Logic animasi & overlay sudah pindah ke dalam ProfileSidebar
            ProfileSidebar()

            if (state.showPlayer) {
                PlayerScreenBottomSheet(
                    sheetState = state.sheetState,
                    onDismissRequest = onDismissPlayer,
                    onTimerClick = onTimerClick
                )
            }
        }
    }
}