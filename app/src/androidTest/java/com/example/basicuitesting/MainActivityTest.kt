package com.example.basicuitesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Test
    fun testActivity_InView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_navToSecondaryActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //mainActivity
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).perform(click())
        //secondary activity
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        pressBack()
        //mainActivity
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}