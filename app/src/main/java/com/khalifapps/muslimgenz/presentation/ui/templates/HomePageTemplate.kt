package com.khalifapps.muslimgenz.presentation.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.ui.molecules.home.HomeTopBar
import com.khalifapps.muslimgenz.presentation.ui.organisms.home.*

@Composable
fun HomePageTemplate(
    onNavigateToReflection: () -> Unit,
    onNavigateToPlaylist: () -> Unit,
    onNavigateToPrayer: () -> Unit
) {
    val dimens = AppTheme.dimens
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(vertical = dimens.paddingLarge)
    ) {
        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { HomeTopBar() }

        Spacer(modifier = Modifier.height(dimens.paddingLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { NewsUpdatedSection() }

        Spacer(modifier = Modifier.height(dimens.paddingLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { GreetingCard() }

        Spacer(modifier = Modifier.height(dimens.paddingLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { PrayerTimeCard() }

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) {
            MenuGrid(
                onNavigateToPrayer = onNavigateToPrayer
            )
        }

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        DiscoverContentSection()

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        VibesOfTheDaysSection(
            onPlaylistClick = onNavigateToPlaylist
        )

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { InspirationReelsSection() }

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { AyahOfTheDayCard() }

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        Box(modifier = Modifier.padding(horizontal = dimens.paddingLarge)) { KajianRecommendationSection() }

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        WisdomSection()

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

        ReflectionAyahSection(
            onReflectClick = onNavigateToReflection
        )

        Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))
    }
}