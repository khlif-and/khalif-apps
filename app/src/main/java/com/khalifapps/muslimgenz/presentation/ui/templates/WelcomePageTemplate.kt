package com.khalifapps.muslimgenz.presentation.ui.templates

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.ui.atoms.SplashBackground

@Composable
fun WelcomePageTemplate(
    headerContent: @Composable () -> Unit,
    footerContent: @Composable () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val screenHeight = maxHeight
        
        SplashBackground()
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = screenHeight)
                    .padding(AppTheme.dimens.paddingLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Top push
                Spacer(modifier = Modifier.weight(1f))
                
                // Header Slot
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    headerContent()
                }
                
                Spacer(modifier = Modifier.height(AppTheme.dimens.spacingHeader))
                
                // Content Slot (Buttons)
                content()
                
                // Bottom push
                Spacer(modifier = Modifier.weight(1f))
                
                // Footer Slot
                footerContent()
                
                Spacer(modifier = Modifier.height(AppTheme.dimens.paddingHuge))
            }
        }
    }
}
