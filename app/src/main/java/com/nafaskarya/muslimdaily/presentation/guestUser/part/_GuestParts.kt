package com.nafaskarya.muslimdaily.presentation.guestUser.part

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.commons.cards.CommonContentCard
import com.nafaskarya.muslimdaily.presentation.core.commons.cards.CommonContentSection
import com.nafaskarya.muslimdaily.presentation.core.commons.cards.CommonCompilationSection
import com.nafaskarya.muslimdaily.presentation.core.components.SliderCard.QuotesSlider
import com.nafaskarya.muslimdaily.presentation.core.components.SliderCard.SliderCard
import com.nafaskarya.muslimdaily.presentation.core.components.cardSection.CardSlider.MoreLikeThis
import com.nafaskarya.muslimdaily.presentation.core.components.cardSection.discover.DiscoverCardSlider
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestCategorySection
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestHeaderSection
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.MenuSection
import com.nafaskarya.muslimdaily.presentation.core.components.pickSectioCard.PickSectionCard
import com.nafaskarya.muslimdaily.presentation.core.components.sampleSection.SampleSection
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

fun LazyListScope.guestHeaderPart(
    dimen: WindowDimensions,
    navController: NavController
) {
    item(key = "header") {
        // PERBAIKAN: Gunakan named argument 'dimen =' karena parameter pertama fungsi adalah 'modifier'
        GuestHeaderSection(
            dimen = dimen,
            onProfileClick = { navController.navigate("profile_screen") }
        )
    }
}

fun LazyListScope.guestCategoryPart(dimen: WindowDimensions) {
    item(key = "categories") {
        // Gunakan named argument juga disini untuk keamanan
        GuestCategorySection(dimen = dimen)
    }
}

fun LazyListScope.guestMainContentPart(
    dimen: WindowDimensions,
    onPlayClick: () -> Unit
) {
    item(key = "gen_z") {
        CommonContentSection(
            title = stringResource(R.string.title_section_gen_z),
            items = GuestData.genZList,
            dimen = dimen,
            onSeeAllClick = { },
            itemContent = { item ->
                CommonContentCard(
                    title = stringResource(id = item.title),
                    description = stringResource(id = item.description),
                    image = item.imageData,
                    dimen = dimen,
                    onClick = { onPlayClick() }
                )
            }
        )
    }

    item(key = "menu_section") {
        MenuSection(dimen = dimen)
    }

    item(key = "trending_now") {
        CommonContentSection(
            title = stringResource(R.string.title_section_trending),
            items = GuestData.trendingList,
            dimen = dimen,
            onSeeAllClick = { },
            itemContent = { item ->
                CommonContentCard(
                    title = stringResource(id = item.title),
                    description = stringResource(id = item.description),
                    image = item.imageData,
                    dimen = dimen,
                    onClick = { onPlayClick() }
                )
            }
        )
    }
}

fun LazyListScope.guestDiscoveryPart(
    dimen: WindowDimensions,
    navController: NavController
) {
    item(key = "section_kitab") {
        CommonCompilationSection(
            title = "From the community",
            dataList = GuestData.kitabList,
            dimen = dimen,
            onItemClick = { }
        )
    }

    item(key = "shorts") { SliderCard() }

    item(key = "section_doa") {
        CommonCompilationSection(
            title = "Doa Pilihan",
            dataList = GuestData.doaList,
            dimen = dimen,
            onItemClick = { }
        )
    }

    item(key = "sample_section") { SampleSection() }
    item(key = "quotes_slider") { QuotesSlider() }
    item(key = "discover") { DiscoverCardSlider() }
    item(key = "hits") {
        MoreLikeThis { navController.navigate("playlist_screen") }
    }
    item(key = "pick_artists") { PickSectionCard() }
}