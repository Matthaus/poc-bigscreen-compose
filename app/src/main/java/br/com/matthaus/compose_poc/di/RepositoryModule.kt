package br.com.matthaus.compose_poc.di

import br.com.matthaus.compose_poc.repository.search.SearchRepository
import br.com.matthaus.compose_poc.repository.search.SearchRepositoryApi
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryApi(
            omdbApi = get()
        )
    }
}
