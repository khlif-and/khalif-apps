package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.R
import com.khalifapps.muslimgenz.presentation.theme.AppTheme

@Composable
fun WisdomSection(
    modifier: Modifier = Modifier
) {
    val dimens = AppTheme.dimens

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.paddingMedium)
            .clip(RoundedCornerShape(dimens.radiusXLarge))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color(0x66000000))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimens.paddingExtraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "WISDOM OF THE DAY",
                color = Color(0xFFD4AF37),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(dimens.paddingLarge))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimens.paddingLarge)
                    .clip(RoundedCornerShape(dimens.radiusLarge))
                    .background(Color(0x26FFFFFF))
                    .border(
                        width = 1.dp,
                        color = Color(0x33FFFFFF),
                        shape = RoundedCornerShape(dimens.radiusLarge)
                    )
                    .padding(
                        horizontal = dimens.paddingLarge,
                        vertical = dimens.paddingExtraLarge
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "\"The best amongst you are those who have the best manners and character.\"",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )

                    Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(2.dp)
                            .background(Color(0xFFD4AF37))
                    )

                    Spacer(modifier = Modifier.height(dimens.paddingLarge))

                    Text(
                        text = "— PROPHET MUHAMMAD (ﷺ)",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}