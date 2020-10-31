package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.bumptech.glide.request.RequestOptions
import com.example.basicuitesting.R
import com.example.basicuitesting.data.DummyMovies
import com.example.basicuitesting.data.source.MoviesDataSource
import com.example.basicuitesting.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test


//@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {

    @Test
    fun test_isMovieDataVisible() {
        //GIVEN
        val movie_id = 1
        val title = DummyMovies.movies[1].title
        val description = DummyMovies.movies[1].description
        val movie = DummyMovies.movies[1]
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