package com.khalifapps.muslimgenz.presentation.widget

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.khalifapps.muslimgenz.presentation.theme.AppBackground
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White

class SimpleWidget : GlanceAppWidget() {

    override var stateDefinition = PreferencesGlanceStateDefinition

    companion object {
        val countKey = intPreferencesKey("count")
    }

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            val count = currentState(key = countKey) ?: 0
            val quotes = listOf(
                "Maka sesungguhnya bersama kesulitan ada kemudahan.",
                "Allah tidak membebani seseorang melainkan sesuai dengan kesanggupannya.",
                "Barangsiapa bertakwa kepada Allah niscaya Dia akan mengadakan baginya jalan keluar.",
                "Dan Dia memberinya rezeki dari arah yang tiada disangka-sangkanya.",
                "Sesungguhnya Allah beserta orang-orang yang sabar."
            )
            val currentQuote = quotes[count % quotes.size]

            GlanceTheme {
                Box(
                    modifier = GlanceModifier
                        .fillMaxSize()
                        .background(ColorProvider(AppBackground))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = GlanceModifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Muslim Gen Z",
                            style = TextStyle(
                                color = ColorProvider(OrangePrimary),
                                fontSize = 12.sp
                            )
                        )
                        
                        Spacer(modifier = GlanceModifier.height(8.dp))
                        
                        Text(
                            text = "\"$currentQuote\"",
                            style = TextStyle(
                                color = ColorProvider(White),
                                fontSize = 16.sp,
                                textAlign = androidx.glance.text.TextAlign.Center
                            ),
                            modifier = GlanceModifier.padding(horizontal = 8.dp)
                        )

                        Spacer(modifier = GlanceModifier.height(16.dp))

                        // Refresh Button
                        Row(
                            modifier = GlanceModifier
                                .clickable(actionRunCallback<RefreshActionCallback>())
                                .background(ColorProvider(White.copy(alpha = 0.1f)))
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Refresh Ayat",
                                style = TextStyle(
                                    color = ColorProvider(White),
                                    fontSize = 12.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
