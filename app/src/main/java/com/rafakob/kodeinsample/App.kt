package com.rafakob.kodeinsample

import android.app.Application
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.androidActivityScope
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.rafakob.kodeinsample.main.MainPresenter

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(autoAndroidModule(this@App))

        bind<MainPresenter>() with autoScopedSingleton(androidActivityScope) { MainPresenter() }
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(androidActivityScope.lifecycleManager)
    }
}