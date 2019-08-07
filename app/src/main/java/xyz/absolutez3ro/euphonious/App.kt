package xyz.absolutez3ro.euphonious

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import xyz.absolutez3ro.euphonious.di.groupModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(groupModule)
        }
    }
}