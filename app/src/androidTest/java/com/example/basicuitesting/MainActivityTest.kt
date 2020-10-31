package com.example.basicuitesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.basicuitesting.ui.movie.MainActivity
import org.junit.Test

//@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

 /*   @Test
    fun test_validateIntentSentToPickPackage() {
        //GIVEN
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val expectedValue =
            "HAHA MY NAME IS ROBOT I WILL KILL YOU HAHAHAHAHAHA LOL MY NAME IS ROBOT"

        //execute and verify
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_you_name)).check(matches(isDisplayed()))
        onView(withText(R.string.ok)).perform(click())
        onView(withText(R.string.text_enter_you_name)).check(matches(isDisplayed()))

        //enter some input
        onView(withId(R.id.md_input_message)).perform(typeText(expectedValue))
        onView(withText(R.string.ok)).perform(click())
        //make sure dialog gone
        onView(withText(R.string.text_enter_you_name)).check(doesNotExist())
        //confirm name is set to textView in activity
        onView(withId(R.id.text_name)).check(matches(withText(expectedValue)))
    }*/


}