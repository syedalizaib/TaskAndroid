package com.taskandroid.di.module

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import androidx.multidex.MultiDex
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {


        private lateinit var instance: App
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModules))
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}