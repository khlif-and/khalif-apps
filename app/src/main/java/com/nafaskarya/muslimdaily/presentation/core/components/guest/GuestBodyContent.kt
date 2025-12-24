package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestDiscoveryPart
import com.nafaskarya.muslimdaily.presentation.guestUser.part.guestMainContentPart

private val FillMaxSizeModifier = Modifier.fillMaxSize()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GuestBodyContent(
    state: GuestScreenState,
    navController: NavController,
    paddingValues: PaddingValues
) {
    val topPadding = paddingValues.calculateTopPadding()

    val listContentPadding = remember {
        PaddingValues(
            top = 0.dp,
            bottom = 120.dp
        )
    }

    val onShowPlayer = remember(state) {
        { state.showPlayer = true }
    }

    val onProfileClick = remember(state) {
        { state.toggleSidebar() }
    }

    LazyColumn(
        modifier = FillMaxSizeModifier,
        contentPadding = listContentPadding
    ) {
        // Sticky Header agar tetap menempel di atas saat scroll
        stickyHeader(key = "header_profile") {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ColorConstant.BackgroundDark)
            ) {
                Spacer(modifier = Modifier.height(topPadding))

                GuestHeaderSection(
                    dimen = state.dimen,
                    onProfileClick = onProfileClick
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        guestMainContentPart(
            dimen = state.dimen,
            onPlayClick = onShowPlayer
        )

        guestDiscoveryPart(
            dimen = state.dimen,
            navController = navController
        )
    }
}