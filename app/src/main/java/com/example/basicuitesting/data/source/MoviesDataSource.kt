package com.example.basicuitesting.data.source

import com.example.basicuitesting.data.Movie

interface MoviesDataSource {
    fun getMovie(movieId:Int): Movie?
}