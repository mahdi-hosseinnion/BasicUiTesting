package com.example.basicuitesting.ui.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.basicuitesting.R
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import org.junit.Test

class MovieNavigationTest {

    @Test
    fun test_movieNavigation() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //check is movie detail frg in view
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))
        //go to director fragment and check is that in view
        onView(withId(R.id.movie_directiors)).perform(click())
        onView(withId(R.id.fragment_directors_parent)).check(matches(isDisplayed()))

        pressBack()
        //check is movie detail frg in view
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))

        //go to starActor fragment and check is that in view
        onView(withId(R.id.movie_star_actors)).perform(click())
        onView(withId(R.id.fragment_star_actors_parent)).check(matches(isDisplayed()))

        pressBack()
    }
}