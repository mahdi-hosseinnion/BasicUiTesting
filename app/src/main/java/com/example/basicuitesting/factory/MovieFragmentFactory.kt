package com.example.basicuitesting.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.example.basicuitesting.data.source.MoviesDataSource
import com.example.basicuitesting.ui.movie.DirectorsFragment
import com.example.basicuitesting.ui.movie.MovieDetailFragment
import com.example.basicuitesting.ui.movie.StarActorsFragment

class MovieFragmentFactory
constructor(
    private val requestOptions: RequestOptions?,
    private val movieDataSource: MoviesDataSource?
) : FragmentFactory() {
    private val TAG = "MovieFragmentFactory"
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            DirectorsFragment::class.java.name -> DirectorsFragment()
            MovieDetailFragment::class.java.name -> {
                if (requestOptions != null && movieDataSource != null) {
                    MovieDetailFragment(
                        requestOptions,
                        movieDataSource
                    )
                } else {
                    super.instantiate(classLoader, className)
                }
            }
            StarActorsFragment::class.java.name -> StarActorsFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}