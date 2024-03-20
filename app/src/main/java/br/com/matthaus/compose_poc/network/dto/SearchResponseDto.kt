package br.com.matthaus.compose_poc.network.dto

import com.google.gson.annotations.SerializedName

data class SearchResponseDto(
    @SerializedName("Search") val search: List<MovieDto>
)
