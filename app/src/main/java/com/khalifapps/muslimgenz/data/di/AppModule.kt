package com.khalifapps.muslimgenz.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // This module is now reserved for app-wide dependencies (e.g. SharedPreferences, Context helpers)
    // Network dependencies have been moved to NetworkModule
}
