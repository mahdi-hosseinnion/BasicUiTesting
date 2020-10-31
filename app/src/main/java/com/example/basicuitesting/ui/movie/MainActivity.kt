package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.example.basicuitesting.R
import com.example.basicuitesting.data.source.MovieRemoteDataSource
import com.example.basicuitesting.data.source.MoviesDataSource
import com.example.basicuitesting.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {
    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {

            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment::class.java, bundle)
                .commit()

        }
    }

    private fun initDependencies() {

        // glide
        requestOptions = RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)

        // Data Source
        moviesDataSource = MovieRemoteDataSource()
    }
}