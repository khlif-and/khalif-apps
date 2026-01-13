package com.khalifapps.muslimgenz.presentation.ui.pages.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import com.khalifapps.muslimgenz.presentation.ui.atoms.SplashBackground

@Composable
fun SplashPage(
    onSplashFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        onSplashFinished()
    }
    SplashBackground()
}
