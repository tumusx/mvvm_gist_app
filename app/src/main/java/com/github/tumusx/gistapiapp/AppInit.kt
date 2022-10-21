package com.github.tumusx.gistapiapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppInit : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}