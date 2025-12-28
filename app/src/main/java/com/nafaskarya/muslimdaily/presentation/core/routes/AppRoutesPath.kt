package com.nafaskarya.muslimdaily.presentation.core.routes

sealed class AppDestination(val route: String) {
    data object Splash : AppDestination("splash")
    data object Guest : AppDestination("guest")
    data object Onboarding : AppDestination("onboarding")
    data object Login : AppDestination("login")
    data object Signup : AppDestination("signup")
    data object ForgotPassword : AppDestination("forgot_password")
    data object Home : AppDestination("home")
    data object Search : AppDestination("search")
    data object Library : AppDestination("library")
    data object Premium : AppDestination("premium")
    data object Create : AppDestination("create")
    data object Player : AppDestination("player")
    data object Profile : AppDestination("profile_screen")
    data object Playlist : AppDestination("playlist_screen")
    data object Share : AppDestination("share")
    data object PlayerMoreMenu : AppDestination("player_more_menu")
}