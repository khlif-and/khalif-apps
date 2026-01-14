package com.khalifapps.muslimgenz.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khalifapps.muslimgenz.presentation.navigation.Routes
import com.khalifapps.muslimgenz.presentation.theme.MuslimGenzTheme
import com.khalifapps.muslimgenz.presentation.ui.pages.onboarding.WelcomePage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.RegisterPage
import com.khalifapps.muslimgenz.presentation.ui.pages.splash.SplashPage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.LoginEmailPage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.RegisterEmailPage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.RegisterPhonePage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.VerifyOtpPage
import com.khalifapps.muslimgenz.presentation.ui.pages.auth.LoginPhonePage
import com.khalifapps.muslimgenz.presentation.ui.pages.choice.ChoiceUstadzPage
import com.khalifapps.muslimgenz.presentation.ui.pages.choice.ChoiceTopicPage
import com.khalifapps.muslimgenz.presentation.ui.pages.result.ResultPage
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

@Composable
fun MainApp(
    startDestination: String? = null
) {
    MuslimGenzTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = startDestination ?: Routes.Splash,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(Routes.Splash) {
                SplashPage(
                    onSplashFinished = {
                        navController.navigate(Routes.Welcome) {
                            popUpTo(Routes.Splash) { inclusive = true }
                        }
                    }
                )
            }
            composable(Routes.Welcome) {
                WelcomePage(
                    onRegisterClick = {
                        navController.navigate(Routes.Register)
                    },
                    onLoginClick = {
                        navController.navigate(Routes.LoginEmail)
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
                    },
                    onRegisterEmailClick = {
                        navController.navigate(Routes.RegisterEmail)
                    },
                    onRegisterPhoneClick = {
                        navController.navigate(Routes.RegisterPhone)
                    }
                )
            }
            composable(Routes.Login) {
            }
            composable(Routes.LoginEmail) {
                LoginEmailPage(
                    onLoginSuccess = {
                        navController.navigate(Routes.ChoiceUstadz) {
                            popUpTo(Routes.Welcome) { inclusive = true }
                        }
                    }
                )
            }
            composable(Routes.LoginPhone) {
                LoginPhonePage(
                    onLoginSuccess = {
                    }
                )
            }
            composable(Routes.RegisterEmail) {
                RegisterEmailPage(
                    onRegisterSuccess = {
                    }
                )
            }
            composable(Routes.RegisterPhone) {
                RegisterPhonePage(
                    onRegisterSuccess = { 
                        navController.navigate(Routes.VerifyOtp)
                    }
                )
            }
            composable(Routes.VerifyOtp) {
                VerifyOtpPage(
                    onVerifyClick = { 
                        navController.navigate(Routes.ChoiceUstadz) {
                            popUpTo(Routes.VerifyOtp) { inclusive = true }
                        }
                    },
                    onResendClick = { }
                )
            }
            composable(Routes.ChoiceUstadz) {
                ChoiceUstadzPage(
                    onContinueClick = {
                        navController.navigate(Routes.ChoiceTopic) {
                            popUpTo(Routes.ChoiceUstadz) { inclusive = true }
                        }
                    },
                    onSkipClick = {
                        navController.navigate(Routes.ChoiceTopic) {
                            popUpTo(Routes.ChoiceUstadz) { inclusive = true }
                        }
                    }
                )
            }
            composable(Routes.ChoiceTopic) {
                ChoiceTopicPage(
                    onContinueClick = {
                        navController.navigate(Routes.Result) {
                            popUpTo(Routes.ChoiceTopic) { inclusive = true }
                        }
                    },
                    onSkipClick = {
                        navController.navigate(Routes.Result) {
                            popUpTo(Routes.ChoiceTopic) { inclusive = true }
                        }
                    }
                )
            }
            composable(Routes.Result) {
                ResultPage(
                    onFinished = {
                        // TODO: Navigate to Home Dashboard
                    }
                )
            }
        }
    }
}
