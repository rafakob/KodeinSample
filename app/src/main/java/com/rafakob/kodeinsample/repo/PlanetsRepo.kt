package com.rafakob.kodeinsample.repo

import com.rafakob.kodeinsample.entity.Planet
import com.rafakob.kodeinsample.entity.Planets
import io.reactivex.Single

interface PlanetsRepo {
    fun planets(): Single<Planets>
    fun planet(id: Int): Single<Planet>
}