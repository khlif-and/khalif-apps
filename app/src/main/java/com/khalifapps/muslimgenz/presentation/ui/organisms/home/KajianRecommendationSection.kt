package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.GoldPrimary
import com.khalifapps.muslimgenz.presentation.theme.HomeStrings
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.molecules.home.KajianCard

@Composable
fun KajianRecommendationSection() {
    val dimens = AppTheme.dimens
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = HomeStrings.KAJIAN_HEADER,
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

        KajianCard()
    }
}
