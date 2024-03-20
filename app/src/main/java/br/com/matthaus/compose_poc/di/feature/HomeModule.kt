package br.com.matthaus.compose_poc.di.feature

import br.com.matthaus.compose_poc.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(
            pageService = get()
        )
    }
}