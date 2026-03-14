package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
fun ReflectionAyahSection(
    modifier: Modifier = Modifier,
    onReflectClick: () -> Unit
) {
    val dimens = AppTheme.dimens

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.paddingLarge)
            .height(450.dp)
            .clip(RoundedCornerShape(dimens.radiusLarge))
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
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0x22000000),
                            Color(0xAA000000),
                            Color(0xEE000000)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimens.paddingLarge),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0x33000000))
                    .border(
                        width = 1.dp,
                        color = Color(0x44D4AF37),
                        shape = CircleShape
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "WISDOM OF THE DAY",
                    color = Color(0xFFD4AF37),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(dimens.paddingMedium))

            Text(
                text = "\"For indeed, with hardship [will be] ease. \"",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
            )

            Spacer(modifier = Modifier.height(dimens.paddingSmall))

            Text(
                text = "Surah Ash-Sharh 94:5",
                color = Color(0xFFD0D0D0),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

            Button(
                onClick = onReflectClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD3A849)),
                shape = CircleShape,
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Reflect Now",
                        color = Color(0xFF222222),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFF222222),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}