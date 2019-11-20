package com.shady.tiger

import android.app.Application
import com.shady.tiger.ui.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App  : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(mainModule)
        }
    }

}