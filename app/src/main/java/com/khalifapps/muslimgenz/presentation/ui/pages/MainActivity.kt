package com.khalifapps.muslimgenz.presentation.ui.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge // Tambahkan import ini
import com.khalifapps.muslimgenz.presentation.ui.MainApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memaksa aplikasi menggambar UI hingga ke ujung layar (Edge-to-Edge)
        enableEdgeToEdge()

        val route = intent.getStringExtra("route")

        // Log Firebase Token for testing
        com.google.firebase.messaging.FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                android.util.Log.w("FCM_TOKEN", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            android.util.Log.d("FCM_TOKEN", "Token: $token")
        }

        setContent {
            MainApp(startDestination = route)
        }
    }
}