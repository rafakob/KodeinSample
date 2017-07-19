package com.rafakob.kodeinsample.features.main

import com.rafakob.kodeinsample.core.MvpPresenter
import com.rafakob.kodeinsample.repo.PlanetsRepo

class MainPresenter(private val planetsRepo: PlanetsRepo) : MvpPresenter<MainView>() {
    fun getPlanets() {
        planetsRepo.planets()
                .subscribe({ view?.setPlanets(it.results) }, { it.printStackTrace() })
    }
}