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
import com.khalifapps.muslimgenz.presentation.ui.molecules.home.ReelCard

@Composable
fun InspirationReelsSection() {
    val dimens = AppTheme.dimens
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = HomeStrings.SECTION_REELS,
                color = White,
                fontSize = dimens.textSizeSection,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = HomeStrings.SEE_ALL,
                color = GoldPrimary,
                fontSize = dimens.textSizeBody,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(dimens.paddingMedium))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimens.paddingMedium),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                ReelCard(
                    title = HomeStrings.REEL_MORNING_DHIKR,
                    views = HomeStrings.REEL_MORNING_VIEWS,
                    imageRes = R.drawable.bg_reel_morning
                )
            }
            item {
                ReelCard(
                    title = HomeStrings.REEL_CALLIGRAPHY,
                    views = HomeStrings.REEL_CALLIGRAPHY_VIEWS,
                    imageRes = R.drawable.bg_reel_calligraphy
                )
            }
        }
    }
}
