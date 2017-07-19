package com.rafakob.kodeinsample.repo

import com.rafakob.kodeinsample.api.PlanetsService
import com.rafakob.kodeinsample.entity.Planet
import com.rafakob.kodeinsample.entity.Planets
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlanetsRepoImpl(private val planetsService: PlanetsService) : PlanetsRepo {
    override fun planets(): Single<Planets> {
        return planetsService.planets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun planet(id: Int): Single<Planet> {
        return planetsService.planet(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}