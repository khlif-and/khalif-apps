package com.khalifapps.muslimgenz.presentation.ui.pages.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.khalifapps.muslimgenz.presentation.ui.atoms.loaders.AppLoader

@Composable
fun LoaderPage(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        AppLoader()
    }
}
