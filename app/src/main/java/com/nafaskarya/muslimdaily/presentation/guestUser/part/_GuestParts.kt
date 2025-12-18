package com.nafaskarya.muslimdaily.presentation.guestUser.part

import androidx.compose.foundation.lazy.LazyListScope
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.components.SliderCard.SliderCard
import com.nafaskarya.muslimdaily.presentation.core.components.SliderCard.QuotesSlider
import com.nafaskarya.muslimdaily.presentation.core.components.cardSection.CardSlider.MoreLikeThis
import com.nafaskarya.muslimdaily.presentation.core.components.cardSection.discover.DiscoverCardSlider
import com.nafaskarya.muslimdaily.presentation.core.components.kitabSection.KitabSliderDailySection
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.MenuSection
import com.nafaskarya.muslimdaily.presentation.core.components.pickSectioCard.PickSectionCard
import com.nafaskarya.muslimdaily.presentation.core.components.sampleSection.SampleSection
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
fun LazyListScope.guestHeaderPart(
    dimen: WindowDimensions,
    navController: NavController
) {
    item(key = "header") {
        GuestHeaderSection(dimen) { navController.navigate("profile_screen") }
    }
}

fun LazyListScope.guestCategoryPart(dimen: WindowDimensions) {
    item(key = "categories") { GuestCategorySection(dimen) }
}

fun LazyListScope.guestMainContentPart(
    dimen: WindowDimensions,
    onPlayClick: () -> Unit
) {
    item(key = "gen_z") {
        GuestContentSection("Lagi Gen Z banget", GuestData.genZList, dimen) {
            onPlayClick()
        }
    }
    item(key = "menu_section") { MenuSection() }
}

fun LazyListScope.guestDiscoveryPart(navController: NavController) {
    item(key = "kitab") { KitabSliderDailySection() }
    item(key = "shorts") { SliderCard() }
    item(key = "sample_section") { SampleSection() }
    item(key = "quotes_slider") { QuotesSlider() }
    item(key = "discover") { DiscoverCardSlider() }
    item(key = "hits") {
        MoreLikeThis { navController.navigate("playlist_screen") }
    }
    item(key = "pick_artists") { PickSectionCard() }
}