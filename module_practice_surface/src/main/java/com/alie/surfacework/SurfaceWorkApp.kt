package com.alie.surfacework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class SurfaceWorkApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}