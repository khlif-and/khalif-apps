package com.khalifapps.muslimgenz.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.khalifapps.muslimgenz.data.local.notification.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DailyReminderWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val notificationHelper: NotificationHelper
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            notificationHelper.showNotification(
                "Assalamualaikum!",
                "Jangan lupa baca Al-Quran hari ini ya ✨"
            )
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
