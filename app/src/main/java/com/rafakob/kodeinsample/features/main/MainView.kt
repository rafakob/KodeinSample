package com.rafakob.kodeinsample.features.main

import com.rafakob.kodeinsample.core.MvpView
import com.rafakob.kodeinsample.entity.Planet

interface MainView : MvpView {
    fun setPlanets(planets: List<Planet>)
}