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
import kotlinx.android.synthetic.main.fragment_directors.*
import org.junit.Assert.*
import org.junit.Test

class DirectorsFragmentTest {

    @Test
    fun test_isDirectorTextVisible() {

        //setup
        val factory = MovieFragmentFactory()
        val bundleData = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val bundle = Bundle()
        bundle.putStringArrayList("directors", bundleData)
        //act
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = factory
        )
        //check
        onView(withId(R.id.directors_text))
            .check(matches(withText(DirectorsFragment.stringBuilderForDirectors(bundleData))))
    }
}