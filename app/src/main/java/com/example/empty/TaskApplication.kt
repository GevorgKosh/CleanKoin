package com.example.empty

import android.app.Application
import com.example.empty.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TaskApplication)
            androidFileProperties()
            modules(listOf(apiModule, repositoryModule, networkModule, viewModelModule))
        }
    }
}