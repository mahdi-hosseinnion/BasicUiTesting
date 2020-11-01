package com.example.basicuitesting.ui.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.basicuitesting.R
import com.example.basicuitesting.data.DummyMovies
import com.example.basicuitesting.ui.movie.DirectorsFragment.Companion.stringBuilderForDirectors
import com.example.basicuitesting.ui.movie.StarActorsFragment.Companion.stringBuilderForStarActors
import com.example.basicuitesting.util.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MovieListFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }


    val LIST_ITEM_IN_TEST = 4
    val MOVIE_TEST = DummyMovies.movies[LIST_ITEM_IN_TEST]

    /*
        recyclerView comes into view
     */
    @Test
    fun a_test_recyclerView_isDisplayed() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /*
        select list item, nav to detailFragment
        correct movie is in view
     */
    @Test
    fun recyclerView_selectItem_navToDetailFrg() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>
                    (LIST_ITEM_IN_TEST, click())
            )
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_TEST.title)))

    }

    /*
       select list item, nav to detailFragment
        correct movie is in view
        pressBack
     */
    @Test
    fun recyclerView_selectItem_navToDetailFrg_pressBack() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>
                    (LIST_ITEM_IN_TEST, click())
            )
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_TEST.title)))

        pressBack()
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /*
        select list item, nav to detail fragment
        select director textView, nav to director fragment
     */
    @Test
    fun test_navDirectorsFragment_validateDirectorsList() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>
                    (LIST_ITEM_IN_TEST, click())
            )
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_TEST.title)))

        onView(withId(R.id.movie_directiors)).perform(click())

        onView(withId(R.id.directors_text)).check(
            matches(
                withText(
                    stringBuilderForDirectors(
                        MOVIE_TEST.directors!!
                    )
                )
            )
        )
    }

    /*
     select list item, nav to detail fragment
     select director textView, nav to director fragment
  */

    @Test
    fun test_navStarActorFragment_validateStarActorList() {
        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>
                    (LIST_ITEM_IN_TEST, click())
            )
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_TEST.title)))

        onView(withId(R.id.movie_star_actors)).perform(click())

        onView(withId(R.id.star_actors_text)).check(
            matches(
                withText(
                    stringBuilderForStarActors(
                        MOVIE_TEST.star_actors!!
                    )
                )
            )
        )
    }
}