package com.khalifapps.muslimgenz.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khalifapps.muslimgenz.presentation.navigation.Routes
import com.khalifapps.muslimgenz.presentation.theme.MuslimGenzTheme
import com.khalifapps.muslimgenz.presentation.ui.pages.WelcomePage
import com.khalifapps.muslimgenz.presentation.ui.pages.RegisterPage
import com.khalifapps.muslimgenz.presentation.ui.pages.SplashPage
import com.khalifapps.muslimgenz.presentation.ui.pages.LoginEmailPage
import com.khalifapps.muslimgenz.presentation.ui.pages.LoginPhonePage
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

@Composable
fun MainApp() {
    MuslimGenzTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = Routes.Welcome, // Updated start destination to Skip Splash for dev if needed, or back to Splash
            // Actually let's keep Splash as start if that was the flow. 
            // In MainActivity it was Onboarding but with a Splash route available.
            // Wait, previous MainActivity had startDestination = Routes.Onboarding ?
            // Let me check the previous viewed file content.
            // Ah, line 27 in MainActivity said startDestination = Routes.Onboarding.
            // Use that.
            
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(Routes.Splash) {
                SplashPage()
            }
            composable(Routes.Welcome) {
                WelcomePage(
                    onRegisterClick = {
                        navController.navigate(Routes.Register)
                    },
                    onLoginClick = {
                        navController.navigate(Routes.LoginEmail) // Directing generic login to email for now, or updating OnboardingPage to have specific callbacks?
                    },
                    onLoginPhoneClick = {
                        navController.navigate(Routes.LoginPhone)
                    }
                )
            }
            composable(Routes.Register) {
                RegisterPage(
                    onLoginClick = {
                        navController.popBackStack()
                    }
                )
            }
            composable(Routes.Login) {
                // Determine layout or flow for generalized login. 
                // For now, redirecting to LoginEmail as per user request to "make this UI"
                // But typically "LoginPage" might have options.
                // Assuming user wants the "Login Email" specifically.
                // Let's modify the OnboardingPage to nav to LoginEmail on "Login With Email" click?
                // The prompt says "create UI named login email".
                // I will add the route separately and link it.
            }
            composable(Routes.LoginEmail) {
                LoginEmailPage(
                    onLoginSuccess = {
                         // TODO: Home
                    }
                )
            }
            composable(Routes.LoginPhone) {
                LoginPhonePage(
                    onLoginSuccess = {
                        // TODO: Home
                    }
                )
            }
        }
    }
}
