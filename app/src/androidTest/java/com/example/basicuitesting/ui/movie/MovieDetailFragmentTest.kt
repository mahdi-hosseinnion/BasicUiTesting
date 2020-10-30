package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.bumptech.glide.request.RequestOptions
import com.example.basicuitesting.R
import com.example.basicuitesting.data.DummyMovies.THE_RUNDOWN
import com.example.basicuitesting.data.Movie
import com.example.basicuitesting.data.source.MovieRemoteDataSource
import com.example.basicuitesting.data.source.MoviesDataSource
import com.example.basicuitesting.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


//@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun test_isMovieDataVisible() {
        //GIVEN
        val movie_id = 1
        val title = THE_RUNDOWN.title
        val description = THE_RUNDOWN.description
        val movie = THE_RUNDOWN
        //note main project
        //mock
        val moviesDataSource = mockk<MoviesDataSource>()
        every {
            moviesDataSource.getMovie(movie_id)
        } returns (movie)

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        val fragmentFactory = MovieFragmentFactory(requestOptions, moviesDataSource)
        val bundle = Bundle()
        bundle.putInt("movie_id", movie_id)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        onView(withId(R.id.movie_title)).check(matches(withText(title)))
        onView(withId(R.id.movie_description)).check(matches(withText(description)))
    }
}