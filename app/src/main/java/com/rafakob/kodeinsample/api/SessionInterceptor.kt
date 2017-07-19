package com.rafakob.kodeinsample.api

import com.rafakob.kodeinsample.entity.UserSession
import okhttp3.Interceptor
import okhttp3.Response

class SessionInterceptor(val userSession: UserSession) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().newBuilder()
                .addHeader("Authetication", userSession.accessToken)
                .build())
    }
}