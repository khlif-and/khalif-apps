package com.khalifapps.muslimgenz.presentation.ui.pages.home.ReflectionPages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.R

@Composable
fun ReflectionPage(
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF131A20))
    ) {
        ReflectionTopBar(
            onBackClick = onNavigateBack,
            onMenuClick = { }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            ReflectionContentCard(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            ReflectionActionRow()

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0x1AFFFFFF)
            )

            Spacer(modifier = Modifier.height(24.dp))

            ReflectionMeaningSection(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            PropheticGuidanceSection(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            QuranicConnectionSection(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            ReflectionCommentsSection(
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(48.dp)) // Extra padding at bottom for scrolling
        }
    }
}

// Data class for Comments
data class CommentItem(
    val name: String,
    val time: String,
    val text: String,
    val likes: Int,
    val avatarRes: Int,
    val isLikedByMe: Boolean = false,
    val isReply: Boolean = false
)

@Composable
fun ReflectionCommentsSection(modifier: Modifier = Modifier) {
    val dummyComments = listOf(
        CommentItem(
            name = "Amina R.",
            time = "2h ago",
            text = "This was exactly what I needed to read this morning. Truly, ease is always there if we look close enough.",
            likes = 24,
            avatarRes = R.drawable.ic_launcher_background,
            isLikedByMe = true
        ),
        CommentItem(
            name = "Omar Khalid",
            time = "1h ago",
            text = "Spot on, Amina! It's all about changing our perspective. 🙌",
            likes = 3,
            avatarRes = R.drawable.ic_launcher_background,
            isReply = true
        ),
        CommentItem(
            name = "Omar Khalid",
            time = "5h ago",
            text = "Alhamdulillah for these reminders. The challenge today really helped me reframe a tough meeting at work.",
            likes = 8,
            avatarRes = R.drawable.ic_launcher_background
        ),
        CommentItem(
            name = "Zaynab M.",
            time = "1d ago",
            text = "\"Ease is woven into the rain itself.\" That's such a beautiful way to think about it. JazakAllah Khair for this.",
            likes = 15,
            avatarRes = R.drawable.ic_launcher_background
        )
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ChatBubbleOutline,
                contentDescription = null,
                tint = Color(0xFFD4AF37),
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "REFLECTIONS (12)",
                color = Color(0xFFD4AF37),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        // Input Field
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF171F26))
                .border(1.dp, Color(0x1AFFFFFF), RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Share your reflection...",
                color = Color(0xFF6B7280),
                fontSize = 14.sp
            )
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD4AF37))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    tint = Color(0xFF131A20),
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Comments List
        dummyComments.forEach { comment ->
            CommentRow(comment = comment)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CommentRow(comment: CommentItem) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (comment.isReply) {
            // Indentation line for replies
            Box(
                modifier = Modifier
                    .padding(start = 24.dp, end = 16.dp)
                    .width(2.dp)
                    .height(80.dp) // Adjusted based on content height roughly
                    .background(Color(0x33D4AF37)) // Subtle gold line
            )
        }

        Image(
            painter = painterResource(id = comment.avatarRes),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(if (comment.isReply) 32.dp else 40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = comment.name,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = comment.time,
                    color = Color(0xFF6B7280),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = comment.text,
                color = Color(0xFFB0B3B8),
                fontSize = 13.sp,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (comment.isLikedByMe) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (comment.isLikedByMe) Color(0xFFD4AF37) else Color(0xFF6B7280),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = comment.likes.toString(),
                    color = if (comment.isLikedByMe) Color(0xFFD4AF37) else Color(0xFF6B7280),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.width(16.dp))

                Row(modifier = Modifier.clickable { }, verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_revert), // Replace with reply icon
                        contentDescription = "Reply",
                        tint = Color(0xFF6B7280),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Reply",
                        color = Color(0xFF6B7280),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun PropheticGuidanceSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.star_on), // Replace with your badge/star icon
                contentDescription = null,
                tint = Color(0xFFD4AF37),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "PROPHETIC GUIDANCE",
                color = Color(0xFFD4AF37),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            // Main Card Background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 6.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(Color(0xFF171F26))
                    .border(
                        width = 1.dp,
                        color = Color(0x1AFFFFFF),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
            )

            // Vertical Grey Bar
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                    .background(Color(0xFF4A5568)) // Subtle grey color from the design
            )

            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("The Prophet ")
                        withStyle(style = SpanStyle(fontSize = 12.sp)) {
                            append("ﷺ") // Kaligrafi salallahu alaihi wasallam
                        }
                        append(" said: \"Know that victory comes with patience, relief with affliction, and ease with hardship.\"")
                    },
                    color = Color(0xFFE0E0E0),
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "— MUSNAD AHMAD",
                    color = Color(0xFF6B7280), // Dim grey for source
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
        }
    }
}

@Composable
fun QuranicConnectionSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_agenda), // Replace with your Book Icon
                contentDescription = null,
                tint = Color(0xFFD4AF37),
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "QURANIC CONNECTION",
                color = Color(0xFFD4AF37),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min) // Important for vertical yellow bar to match height
        ) {
            // Main Card Background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 6.dp) // Leave space for yellow bar
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(Color(0xFF171F26))
                    .border(
                        width = 1.dp,
                        color = Color(0x1AFFFFFF),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
            )

            // Vertical Yellow Bar
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                    .background(Color(0xFFD4AF37))
            )

            // Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    text = "فَإِنَّ مَعَ الْعُسْرِ يُسْرًا",
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "\"For indeed, with hardship [will be] ease.\" — 94:5",
                    color = Color(0xFFB0B3B8),
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "SURAH ASH-SHARH",
                        color = Color(0xFF7A6B41), // Dimmed gold for subtitle
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    )

                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_lock_silent_mode_off), // Replace with Speaker Icon
                        contentDescription = "Play Audio",
                        tint = Color(0xFFD4AF37),
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { }
                    )
                }
            }
        }
    }
}

@Composable
fun ReflectionMeaningSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "✨ THE MEANING",
                color = Color(0xFFD4AF37),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    color = Color(0x1AFFFFFF), // Subtle border
                    shape = RoundedCornerShape(16.dp)
                )
                .background(Color(0xFF171F26)) // Slightly lighter than main bg
                .padding(20.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Life can feel like a level 10 boss fight sometimes, but this Ayah is the ultimate reminder that struggle and success aren't sequential—they're ")
                    withStyle(style = SpanStyle(color = Color(0xFFD4AF37), fontWeight = FontWeight.SemiBold)) {
                        append("simultaneous")
                    }
                    append(". Ease doesn't just come *after* the storm; it's woven into the rain itself. You're being built for greatness while you're going through it. No cap, your breakthrough is already in motion. 🚀")
                },
                color = Color(0xFFE0E0E0),
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun ReflectionActionRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ActionItem(
            icon = Icons.Filled.Favorite,
            label = "1.2k",
            iconTint = Color(0xFFD4AF37), // Warna Emas/Kuning
            textColor = Color(0xFFD4AF37),
            onClick = { }
        )

        ActionItem(
            icon = Icons.Filled.Bookmark,
            label = "Save",
            iconTint = Color(0xFFB0B3B8), // Warna Abu-abu terang
            textColor = Color(0xFFB0B3B8),
            onClick = { }
        )

        ActionItem(
            icon = Icons.Filled.Share,
            label = "Share",
            iconTint = Color(0xFFB0B3B8),
            textColor = Color(0xFFB0B3B8),
            onClick = { }
        )
    }
}

@Composable
fun ActionItem(
    icon: ImageVector,
    label: String,
    iconTint: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0x0AFFFFFF)), // Background bulat yang samar
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = label,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp
        )
    }
}

@Composable
fun ReflectionContentCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.8f)
            .clip(RoundedCornerShape(24.dp))
            .border(
                width = 1.dp,
                color = Color(0x33D4AF37),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background), // Ganti dengan gambar aslimu
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
                            Color(0x33000000),
                            Color(0x99000000),
                            Color(0xFF131A20)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0x66000000))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "PATIENCE & EASE",
                    color = Color(0xFFD4AF37),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "إِنَّ مَعَ الْعُسْرِ يُسْرًا",
                color = Color(0xFFD4AF37),
                fontSize = 42.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "\"Verily, with hardship comes ease\"",
                color = Color.White,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Surah Ash-Sharh (94:5)",
                color = Color(0xFFB09B63),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ReflectionTopBar(
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF171F26))
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0x0AFFFFFF))
                    .clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFFD4AF37)
                )
            }

            Text(
                text = "Reflection Hub",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0x0AFFFFFF))
                    .clickable { onMenuClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color(0xFFD4AF37)
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color(0x1AFFFFFF)
        )
    }
}