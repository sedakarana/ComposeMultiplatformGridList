package com.sedakarana.filmlerapp

import android.app.Application
import com.sedakarana.filmlerapp.data.di.initializeKoin

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }
}