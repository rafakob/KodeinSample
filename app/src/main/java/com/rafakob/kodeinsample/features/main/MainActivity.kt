package com.rafakob.kodeinsample.features.main

import android.os.Bundle
import com.github.salomonbrys.kodein.instance
import com.rafakob.kodeinsample.R
import com.rafakob.kodeinsample.core.MvpActivity
import com.rafakob.kodeinsample.entity.Planet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpActivity<MainPresenter, MainView>(), MainView {
    override val presenter: MainPresenter by kodein.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getPlanets()
    }

    override fun setPlanets(planets: List<Planet>) {
        result.text = planets.toString()
    }
}
