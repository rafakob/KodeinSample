package com.rafakob.kodeinsample.core

abstract class MvpPresenter<V : MvpView> {
    protected var view: V? = null

    fun bindView(view: V) {
        this.view = view
    }

    fun unbindView() {
        view = null
    }
}