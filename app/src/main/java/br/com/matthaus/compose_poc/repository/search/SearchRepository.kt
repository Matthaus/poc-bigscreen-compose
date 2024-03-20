package br.com.matthaus.compose_poc.repository.search

import br.com.matthaus.compose_poc.model.Movie

interface SearchRepository {
    suspend fun searchMovieByKeyword(query: String): List<Movie>
}