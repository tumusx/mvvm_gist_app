package com.github.tumusx.gistapiapp

import android.app.Application
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppInit : Application(){
    override fun onCreate() {
        Firebase.database.setPersistenceEnabled(true)
    }
}