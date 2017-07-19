package com.rafakob.kodeinsample.dependecies

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.rafakob.kodeinsample.api.PlanetsService
import retrofit2.Retrofit

val apiModule = Kodein.Module {
    bind<PlanetsService>() with singleton { instance<Retrofit>().create(PlanetsService::class.java) }
}