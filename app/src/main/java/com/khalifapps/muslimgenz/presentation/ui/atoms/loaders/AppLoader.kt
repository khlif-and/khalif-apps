package com.khalifapps.muslimgenz.presentation.ui.atoms.loaders

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary

@Composable
fun AppLoader(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = OrangePrimary
    )
}
