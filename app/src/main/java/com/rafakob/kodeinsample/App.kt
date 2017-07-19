package com.rafakob.kodeinsample

import android.app.Application
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.androidActivityScope
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.rafakob.kodeinsample.dependecies.apiModule
import com.rafakob.kodeinsample.dependecies.networkModule
import com.rafakob.kodeinsample.dependecies.repoModule
import com.rafakob.kodeinsample.features.main.MainPresenter

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(autoAndroidModule(this@App))
        import(apiModule)
        import(networkModule)
        import(repoModule)

        bind<MainPresenter>() with autoScopedSingleton(androidActivityScope) { MainPresenter(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(androidActivityScope.lifecycleManager)
    }
}