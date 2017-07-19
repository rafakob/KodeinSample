package com.rafakob.kodeinsample.dependecies

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.google.gson.Gson
import com.rafakob.kodeinsample.api.SessionInterceptor
import com.rafakob.kodeinsample.entity.UserSession
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = Kodein.Module {
    bind<String>("baseUrl") with instance("http://swapi.co/api/")

    bind<UserSession>() with singleton { UserSession() }

    bind<SessionInterceptor>() with singleton { SessionInterceptor(instance()) }

    bind<HttpLoggingInterceptor>() with singleton { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }

    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
                .addInterceptor(instance<SessionInterceptor>())
                .addInterceptor(instance<HttpLoggingInterceptor>())
                .build()
    }

    bind<Retrofit>() with singleton {
        Retrofit.Builder()
                .client(instance())
                .baseUrl(instance<String>("baseUrl"))
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}