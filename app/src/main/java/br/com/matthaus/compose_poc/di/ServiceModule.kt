package br.com.matthaus.compose_poc.di

import br.com.matthaus.compose_poc.service.page.PageService
import br.com.matthaus.compose_poc.service.page.PageServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single<PageService> { PageServiceImpl(get()) }
}