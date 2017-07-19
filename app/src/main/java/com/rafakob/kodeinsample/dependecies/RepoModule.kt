package com.rafakob.kodeinsample.dependecies

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.rafakob.kodeinsample.repo.PlanetsRepo
import com.rafakob.kodeinsample.repo.PlanetsRepoImpl

val repoModule = Kodein.Module {
    bind<PlanetsRepo>() with singleton { PlanetsRepoImpl(instance()) }
}