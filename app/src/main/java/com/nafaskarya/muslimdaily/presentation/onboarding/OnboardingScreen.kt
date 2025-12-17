package com.nafaskarya.muslimdaily.presentation.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@Composable
fun OnboardingScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    val dimen = rememberWindowDimensions()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img_onboarding),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimen.width * 0.06f)
                .padding(top = dimen.height * 0.15f, bottom = dimen.height * 0.05f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoSection(
                size = remember(dimen) {
                    dimen.getResponsiveTextSize(0.25f, min = 80f, max = 150f).value.dp
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            ContentSection(dimen = dimen, onLoginClick = onLoginClick, onSignUpClick = onSignUpClick)
        }
    }
}

@Composable
private fun LogoSection(size: Dp) {
    Image(
        painter = painterResource(id = R.drawable.img_logo),
        contentDescription = "App Logo",
        modifier = Modifier.height(size).wrapContentWidth(),
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun ContentSection(
    dimen: WindowDimensions,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val titleSize = remember(dimen) { dimen.getResponsiveTextSize(0.06f, min = 20f, max = 32f) }
    val dateSize = remember(dimen) { dimen.getResponsiveTextSize(0.05f, min = 16f, max = 28f) }
    val welcomeSize = remember(dimen) { dimen.getResponsiveTextSize(0.045f, min = 14f, max = 24f) }

    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        Text(text = "GET CLOSER TO ALLAH", fontSize = titleSize, fontWeight = FontWeight.Black, color = Color.White)
        Text(text = "Temukan ketenangan...", fontSize = dateSize, color = Color.White.copy(alpha = 0.7f))
        Spacer(modifier = Modifier.height(dimen.height * 0.04f))

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth().height(56.dp)
                .semantics { contentDescription = "Login Button" }, // Identitas untuk testing
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            border = BorderStroke(1.5.dp, Color.White)
        ) {
            Text(text = "Log in", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Don't have an account? Sign up", color = Color.White, modifier = Modifier.clickable { onSignUpClick() })
        }
    }
}