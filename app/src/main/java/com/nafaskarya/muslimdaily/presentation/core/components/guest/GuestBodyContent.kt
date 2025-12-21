package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestDiscoveryPart
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestMainContentPart

@Composable
fun GuestBodyContent(
    state: GuestScreenState,
    navController: NavController,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding(),
            bottom = 120.dp
        )
    ) {
        item { Spacer(modifier = Modifier.height(state.headerHeight)) }

        guestMainContentPart(state.dimen) { state.showPlayer = true }

        guestDiscoveryPart(state.dimen, navController)
    }
}