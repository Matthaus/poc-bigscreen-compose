package br.com.matthaus.compose_poc.di

import br.com.matthaus.compose_poc.network.ApiKeyInterceptor
import br.com.matthaus.compose_poc.network.OmdbApi
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        //In a real implementation the apikey should be on CI/CD environment variables
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor("API KEY GOES HERE"))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OmdbApi::class.java)
    }

}
