package com.rafakob.kodeinsample.core

import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity

abstract class MvpActivity<P : MvpPresenter<V>, V : MvpView> : KodeinAppCompatActivity() {
}