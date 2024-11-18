package com.example.ktorsimpleclient

import android.app.Application
import com.example.ktorsimpleclient.di.apiModule
import com.example.ktorsimpleclient.di.appModule
import org.koin.android.ext.koin.androidContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(
                apiModule(),
                appModule()
            )
        }
    }
}