package com.rafakob.kodeinsample.main

import android.os.Bundle
import com.github.salomonbrys.kodein.instance
import com.rafakob.kodeinsample.R
import com.rafakob.kodeinsample.core.MvpActivity

class MainActivity : MvpActivity<MainPresenter, MainView>() {
    val presenter: MainPresenter by kodein.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.logMsg()
    }
}
