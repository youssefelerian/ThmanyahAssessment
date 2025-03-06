package com.example.thmanyahassessment.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ThmanyahApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}

