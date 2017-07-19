package com.rafakob.kodeinsample.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein

abstract class MvpActivity<out P : MvpPresenter<V>, V : MvpView> : AppCompatActivity(), MvpView {
    val kodein = LazyKodein(appKodein)
    abstract val presenter: P

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }
}