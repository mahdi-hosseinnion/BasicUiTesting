package com.example.basicuitesting.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.basicuitesting.ui.movie.DirectorsFragment
import com.example.basicuitesting.ui.movie.MovieDetailFragment
import com.example.basicuitesting.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {
    private val TAG = "MovieFragmentFactory"
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            DirectorsFragment::class.java.name -> DirectorsFragment()
            MovieDetailFragment::class.java.name -> MovieDetailFragment()
            StarActorsFragment::class.java.name -> StarActorsFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}