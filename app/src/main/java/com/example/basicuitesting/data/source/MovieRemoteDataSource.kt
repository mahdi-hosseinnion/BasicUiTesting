package com.example.basicuitesting.data.source

import com.example.basicuitesting.data.DummyMovies.INFINITY_WAR
import com.example.basicuitesting.data.DummyMovies.THE_RUNDOWN
import com.example.basicuitesting.data.Movie

object MovieRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(INFINITY_WAR)
        addMovie(THE_RUNDOWN)
    }

    private fun addMovie(movie: Movie) {
        MOVIES_REMOTE_DATA[movie.id] = movie
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA.get(movieId)
    }
}