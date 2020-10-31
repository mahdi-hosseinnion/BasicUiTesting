package com.example.basicuitesting.data.source

import com.example.basicuitesting.data.DummyMovies
import com.example.basicuitesting.data.Movie

class MovieRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(5)

    init {
        for (movie in DummyMovies.movies){
            addMovie(movie)
        }
    }

    private fun addMovie(movie: Movie) {
        MOVIES_REMOTE_DATA[movie.id] = movie
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA.get(movieId)
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }
}