package br.com.matthaus.compose_poc.network

import br.com.matthaus.compose_poc.network.dto.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query


interface OmdbApi {
    @GET("/")
    suspend fun searchMovieByKeyword(@Query("s") keyword: String): SearchResponseDto
}