package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.basicuitesting.R
import com.example.basicuitesting.data.DummyMovies.THE_RUNDOWN
import com.example.basicuitesting.factory.MovieFragmentFactory
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Assert.*
import org.junit.Test

class MovieDetailFragmentTest {

    @Test
    fun test_isMovieDataVisible() {
        //setup
        val movie = THE_RUNDOWN
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)
        //act
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        //check
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }
}