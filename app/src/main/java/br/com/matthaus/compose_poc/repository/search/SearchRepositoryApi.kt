package br.com.matthaus.compose_poc.repository.search

import br.com.matthaus.compose_poc.model.Movie
import br.com.matthaus.compose_poc.network.OmdbApi
import br.com.matthaus.compose_poc.network.mapper.MovieMapper

class SearchRepositoryApi(
    private val omdbApi: OmdbApi
) : SearchRepository {

    override suspend fun searchMovieByKeyword(keyword: String): List<Movie> {
        return omdbApi
            .searchMovieByKeyword(keyword)
            .search.map {
                MovieMapper.mapToDomain(it)
            }
    }

}