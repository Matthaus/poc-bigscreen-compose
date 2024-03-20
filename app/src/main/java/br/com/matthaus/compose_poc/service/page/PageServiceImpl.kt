package br.com.matthaus.compose_poc.service.page

import br.com.matthaus.compose_poc.model.Page
import br.com.matthaus.compose_poc.repository.search.SearchRepository
import kotlinx.coroutines.delay

class PageServiceImpl(
    private val searchRepository: SearchRepository
) : PageService {

    override suspend fun getPageByType(type: PageType): Page {
        val firstLine = searchRepository.searchMovieByKeyword("batman")
        val secondLine = searchRepository.searchMovieByKeyword("mission")
        val thirdLine = searchRepository.searchMovieByKeyword("guardian")

        delay(5000L)

        return Page(
            content = listOf(
                firstLine,
                secondLine,
                thirdLine
            )
        )
    }

}