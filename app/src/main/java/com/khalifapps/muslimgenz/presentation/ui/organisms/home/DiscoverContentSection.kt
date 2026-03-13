package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.R
import com.khalifapps.muslimgenz.presentation.theme.*
import com.khalifapps.muslimgenz.presentation.ui.molecules.home.DiscoverCard

@Composable
fun DiscoverContentSection() {
    val dimens = AppTheme.dimens
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.paddingLarge),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = HomeStrings.DISCOVER_HEADER,
                color = White,
                fontSize = dimens.textSizeSubtitle,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = HomeStrings.DISCOVER_SEE_ALL,
                color = IconMuted,
                fontSize = dimens.textSizeBody
            )
        }

        Spacer(modifier = Modifier.height(dimens.paddingMedium))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimens.paddingMedium),
            contentPadding = PaddingValues(horizontal = dimens.paddingLarge),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                DiscoverCard(
                    title = HomeStrings.DISCOVER_ITEM1_TITLE,
                    subtitle = HomeStrings.DISCOVER_ITEM1_SUBTITLE,
                    imageRes = R.drawable.discover_quran_tulips
                )
            }
            item {
                DiscoverCard(
                    title = HomeStrings.DISCOVER_ITEM2_TITLE,
                    subtitle = HomeStrings.DISCOVER_ITEM2_SUBTITLE,
                    imageRes = R.drawable.discover_sajadah_tasbih
                )
            }
            item {
                DiscoverCard(
                    title = HomeStrings.DISCOVER_ITEM3_TITLE,
                    subtitle = HomeStrings.DISCOVER_ITEM3_SUBTITLE,
                    imageRes = R.drawable.discover_kurma_water
                )
            }
        }
    }
}
