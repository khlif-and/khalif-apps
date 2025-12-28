package com.nafaskarya.muslimdaily.presentation.core.routes

import androidx.compose.animation.core.snap
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nafaskarya.muslimdaily.presentation.auth.LoginScreen
import com.nafaskarya.muslimdaily.presentation.core.shared.player.moreMenu.MoreMenuBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.player.sharing.ShareScreen
import com.nafaskarya.muslimdaily.presentation.core.shared.playlist.PlaylistScreen
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.ProfileAccountScreen
import com.nafaskarya.muslimdaily.presentation.guestUser.GuestScreen
import com.nafaskarya.muslimdaily.presentation.onboarding.OnboardingScreen
import com.nafaskarya.muslimdaily.presentation.search.SearchScreen
import com.nafaskarya.muslimdaily.presentation.splash.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoutes() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        NavHost(
            navController = navController,
            startDestination = AppDestination.Splash.route,
            enterTransition = { fadeIn(animationSpec = snap()) },
            exitTransition = { fadeOut(animationSpec = snap()) },
            popEnterTransition = { fadeIn(animationSpec = snap()) },
            popExitTransition = { fadeOut(animationSpec = snap()) }
        ) {
            composable(AppDestination.Splash.route) {
                SplashScreen {
                    navController.navigate(AppDestination.Guest.route) {
                        popUpTo(AppDestination.Splash.route) { inclusive = true }
                    }
                }
            }

            composable(AppDestination.Guest.route) {
                GuestScreen(navController)
            }

            composable(AppDestination.Search.route) {
                SearchScreen()
            }

            composable(AppDestination.Profile.route) {
                ProfileAccountScreen(
                    onBackClick = { navController.popBackStack() },
                    onLogoutConfirmed = {
                        navController.navigate(AppDestination.Login.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }

            composable(AppDestination.Playlist.route) {
                PlaylistScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }

            composable(AppDestination.Login.route) {
                LoginScreen(
                    onLoginClick = { },
                    onSignUpClick = { navController.navigate(AppDestination.Signup.route) }
                )
            }

            composable(AppDestination.Onboarding.route) {
                OnboardingScreen(
                    onLoginClick = { navController.navigate(AppDestination.Login.route) },
                    onSignUpClick = { navController.navigate(AppDestination.Signup.route) }
                )
            }

            composable(AppDestination.Signup.route) {
            }

            composable(AppDestination.Share.route) {
                ShareScreen(
                    onBackClick = { navController.popBackStack() },
                    onCloseClick = { navController.popBackStack() }
                )
            }

            composable(AppDestination.PlayerMoreMenu.route) {
                MoreMenuBottomSheet(
                    onDismissRequest = { navController.popBackStack() }
                )
            }
        }
    }
}