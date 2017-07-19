package com.rafakob.kodeinsample.api

import com.rafakob.kodeinsample.entity.Planet
import com.rafakob.kodeinsample.entity.Planets
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetsService {
    @GET("planets")
    fun planets(): Single<Planets>

    @GET("planets/{id}")
    fun planet(@Query("id") id: Int): Single<Planet>
}