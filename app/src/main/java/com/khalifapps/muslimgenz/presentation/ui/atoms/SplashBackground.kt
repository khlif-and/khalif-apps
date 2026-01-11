package com.khalifapps.muslimgenz.presentation.ui.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalifapps.muslimgenz.presentation.theme.AppBackground

@Composable
fun SplashBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    )
}
