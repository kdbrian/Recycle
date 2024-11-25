package io.github.junrdev.recycler

import android.app.Application
import io.github.junrdev.recycler.ui.presentation.di.firebaseAuthModules
import io.github.junrdev.recycler.ui.presentation.di.localModules
import io.github.junrdev.recycler.ui.presentation.di.wasteModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)

            modules(
                localModules,
                firebaseAuthModules,
                wasteModules
            )
        }
    }
}