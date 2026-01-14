package com.khalifapps.muslimgenz.presentation.widget

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class SimpleWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            // Create a simple UI
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Muslim Gen Z",
                    style = TextStyle(color = androidx.glance.unit.ColorProvider(Color.Black))
                )
                Text(
                    text = "Hello from Glance Widget!",
                    style = TextStyle(color = androidx.glance.unit.ColorProvider(Color.Gray))
                )
            }
        }
    }
}
