package com.rafakob.kodeinsample.main

import android.util.Log
import com.rafakob.kodeinsample.core.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {
    fun logMsg() {
        Log.i("Kodeina", "Test Msg")
    }
}