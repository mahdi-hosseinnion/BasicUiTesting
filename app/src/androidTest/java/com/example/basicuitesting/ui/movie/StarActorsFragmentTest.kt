package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.basicuitesting.R
import com.example.basicuitesting.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{
    @Test
    fun test_isDirectorTextVisible() {

        //setup
        val factory = MovieFragmentFactory(null,null)
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
                        StarActorsFragment.stringBuilderForStarActors(
                            bundleData
                        )
                    )
                )
            )
    }
}
