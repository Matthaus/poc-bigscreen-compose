package br.com.matthaus.compose_poc.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url
        val modifiedUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", apiKey)
            .build()
        val modifiedRequest = originalRequest.newBuilder().url(modifiedUrl).build()
        return chain.proceed(modifiedRequest)
    }
}