package com.khalifapps.muslimgenz.presentation.ui.pages.home

import androidx.compose.runtime.Composable
import com.khalifapps.muslimgenz.presentation.ui.templates.HomePageTemplate

@Composable
fun HomePage(
    onNavigateToReflection: () -> Unit,
    onNavigateToPlaylist: () -> Unit // Tambahkan parameter ini
) {
    HomePageTemplate(
        onNavigateToReflection = onNavigateToReflection,
        onNavigateToPlaylist = onNavigateToPlaylist // Teruskan ke template
    )
}