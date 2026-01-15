package com.khalifapps.muslimgenz.data.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.khalifapps.muslimgenz.data.local.notification.NotificationHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            val title = it.title ?: "Notification"
            val body = it.body ?: ""
            notificationHelper.showNotification(title, body)
        }
        
        // Also handle data payload if needed for background processing
        // But for now, we focus on the notification payload for immediate display
         if (remoteMessage.data.isNotEmpty()) {
            val title = remoteMessage.data["title"] ?: "Notification"
            val body = remoteMessage.data["body"] ?: ""
            // Only show if not shown by notification payload automatically (foreground)
            // Or if specific data handling is required. 
            // For simplicity, we trust the notification payload or use data if notification payload is null
             if (remoteMessage.notification == null) {
                 notificationHelper.showNotification(title, body)
             }
         }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Send token to your server if needed
        // For debugging:
        println("New Firebase Token: $token")
    }
}
