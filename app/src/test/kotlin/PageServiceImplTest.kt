import br.com.matthaus.compose_poc.repository.search.SearchRepository
import br.com.matthaus.compose_poc.service.page.PageServiceImpl
import br.com.matthaus.compose_poc.service.page.PageType
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test


class PageServiceImplTest {

    @Test
    fun `test getPageByType`() = runTest {
        // Given
        val searchRepository = mockk<SearchRepository>()
        val pageService = PageServiceImpl(searchRepository)

        coEvery { searchRepository.searchMovieByKeyword("batman") } returns emptyList()
        coEvery { searchRepository.searchMovieByKeyword("mission") } returns emptyList()
        coEvery { searchRepository.searchMovieByKeyword("guardian") } returns emptyList()

        val response = pageService.getPageByType(PageType.START)

        assert(response.content.size == 3)

    }

}