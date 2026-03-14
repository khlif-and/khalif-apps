package com.khalifapps.muslimgenz.presentation.ui.pages.home

import androidx.compose.runtime.Composable
import com.khalifapps.muslimgenz.presentation.ui.templates.HomePageTemplate

@Composable
fun HomePage(
    onNavigateToReflection: () -> Unit,
    onNavigateToPlaylist: () -> Unit,
    onNavigateToPrayer: () -> Unit
) {
    HomePageTemplate(
        onNavigateToReflection = onNavigateToReflection,
        onNavigateToPlaylist = onNavigateToPlaylist,
        onNavigateToPrayer = onNavigateToPrayer
    )
}