package br.com.matthaus.compose_poc.network.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("imdbID") val imdbId: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val poster: String
)
