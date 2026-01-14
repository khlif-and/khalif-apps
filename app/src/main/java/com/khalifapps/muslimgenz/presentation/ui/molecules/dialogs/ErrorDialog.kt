package com.khalifapps.muslimgenz.presentation.ui.molecules.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import com.khalifapps.muslimgenz.presentation.theme.AppBackground
import com.khalifapps.muslimgenz.presentation.theme.LocalAppDimens
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White

@Composable
fun ErrorDialog(
    title: String = "Terjadi Kesalahan",
    message: String,
    buttonText: String = "OK",
    onDismiss: () -> Unit
) {
    val dimens = LocalAppDimens.current

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(dimens.paddingMedium))
                .background(AppBackground)
                .padding(dimens.paddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimens.paddingMedium)
        ) {
            Text(
                text = title,
                color = White,
                fontSize = dimens.textSizeButton,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            
            Text(
                text = message,
                color = White.copy(alpha = 0.8f),
                fontSize = dimens.textSizeBody,
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = OrangePrimary),
                shape = RoundedCornerShape(dimens.spacingSmall)
            ) {
                Text(
                    text = buttonText,
                    color = White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

