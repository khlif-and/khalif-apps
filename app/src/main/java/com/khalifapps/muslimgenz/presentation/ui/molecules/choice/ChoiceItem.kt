package com.khalifapps.muslimgenz.presentation.ui.molecules.choice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.text.LabelSmall

@Composable
fun ChoiceItem(
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(AppTheme.dimens.choiceAvatarSize)
                .clip(CircleShape)
                .background(if (isSelected) OrangePrimary else Color.LightGray)
        )
        
        Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))
        
        LabelSmall(
            text = name,
            color = if (isSelected) OrangePrimary else White,
            textAlign = TextAlign.Center
        )
    }
}
