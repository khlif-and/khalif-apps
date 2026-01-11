package com.khalifapps.muslimgenz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MuslimGenzApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialization code (DI, Timber, etc.) will go here
    }
}
