package com.devnunu.ticle

import android.app.Application
import com.devnunu.ticle.data.asset.di.assetModule
import com.devnunu.ticle.di.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicleApplication)
            modules(
                assetModule,
                featureModule,
            )
        }
    }
}