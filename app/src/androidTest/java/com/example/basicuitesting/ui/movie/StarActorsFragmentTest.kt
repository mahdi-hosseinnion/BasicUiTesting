package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.basicuitesting.R
import com.example.basicuitesting.factory.MovieFragmentFactory
import org.junit.Test

class StarActorsFragmentTest{
    @Test
    fun test_isDirectorTextVisible() {

        //setup
        val factory = MovieFragmentFactory()
        val bundleData = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val bundle = Bundle()
        bundle.putStringArrayList("star_actors", bundleData)
        //act
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = factory
        )
        //check
        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.withText(
                        StarActorsFragment.stringBuilderForDirectors(
                            bundleData
                        )
                    )
                )
            )
    }
}