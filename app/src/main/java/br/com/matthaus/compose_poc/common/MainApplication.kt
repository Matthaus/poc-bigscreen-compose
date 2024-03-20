package br.com.matthaus.compose_poc.common

import android.app.Application
import br.com.matthaus.compose_poc.di.feature.homeModule
import br.com.matthaus.compose_poc.di.networkModule
import br.com.matthaus.compose_poc.di.repositoryModule
import br.com.matthaus.compose_poc.di.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                networkModule,
                repositoryModule,
                serviceModule,
                homeModule
            )
        }
    }

}