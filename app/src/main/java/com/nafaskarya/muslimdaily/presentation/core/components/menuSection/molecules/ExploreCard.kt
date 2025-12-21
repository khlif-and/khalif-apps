package com.nafaskarya.muslimdaily.presentation.core.components.menuSection.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens

@Composable
fun ExploreCard(
    icon: ImageVector,
    label: String,
    width: Dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(width)
            .aspectRatio(1f)
            // OPTIMASI: GraphicsLayer memaksa rendering via GPU (Hardware Acceleration)
            // Membuat animasi scroll dan clip jauh lebih mulus (buttery smooth)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(Dimens.RadiusLarge)
                shadowElevation = 0f
            }
            .background(ColorConstant.ProfileSurface)
            .clickable(onClick = onClick)
            .padding(Dimens.PaddingSemiLarge)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = ColorConstant.TextWhite,
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.TopStart)
        )

        Text(
            text = label,
            color = ColorConstant.TextWhite,
            fontSize = Dimens.TextBody,
            fontWeight = FontWeight.Medium,
            lineHeight = Dimens.LineHeightBody,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}