package br.com.matthaus.compose_poc.network.mapper

import br.com.matthaus.compose_poc.model.Movie
import br.com.matthaus.compose_poc.network.dto.MovieDto

class MovieMapper {

    companion object {

        fun mapToDomain(movieDto: MovieDto): Movie {
            return Movie(
                title = movieDto.title,
                year = movieDto.year,
                imdbId = movieDto.imdbId,
                type = movieDto.type,
                poster = movieDto.poster
            )
        }

    }

}