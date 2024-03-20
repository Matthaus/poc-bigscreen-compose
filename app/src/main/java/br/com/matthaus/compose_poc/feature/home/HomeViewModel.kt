package br.com.matthaus.compose_poc.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.matthaus.compose_poc.model.Page
import br.com.matthaus.compose_poc.service.page.PageService
import br.com.matthaus.compose_poc.service.page.PageType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pageService: PageService
) : ViewModel() {

    private val _state : MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    val state : StateFlow<HomeState> = _state

    fun fetchPage() {

        viewModelScope.launch {
            val response = pageService.getPageByType(PageType.START)
            _state.value = HomeState.Success(response)
        }

    }

    sealed class HomeState {
        object Loading : HomeState()
        object Error : HomeState()
        data class Success(val page: Page) : HomeState()
    }

}