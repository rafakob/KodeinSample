package com.rafakob.kodeinsample.core

import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein

abstract class MvpActivity<P : MvpPresenter<V>, V : MvpView> : AppCompatActivity() {
    val kodein = LazyKodein(appKodein)

}