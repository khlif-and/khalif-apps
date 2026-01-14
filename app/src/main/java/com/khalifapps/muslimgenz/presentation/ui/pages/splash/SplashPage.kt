package com.khalifapps.muslimgenz.presentation.ui.pages.splash

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import com.khalifapps.muslimgenz.presentation.ui.atoms.SplashBackground

@Composable
fun SplashPage(
    onSplashFinished: () -> Unit
) {
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            // Proceed regardless of permission result
            onSplashFinished()
        }
    )

    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            onSplashFinished()
        }
    }
    SplashBackground()
}

