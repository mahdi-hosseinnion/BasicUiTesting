package com.example.basicuitesting.util

import androidx.test.espresso.IdlingRegistry
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

/*
    option 1:
    difficult way but more verboese
 */
//class EspressoIdlingResourceRule : TestRule {
//    override fun apply(base: Statement?, description: Description?): Statement {
//        return IdlingResourceStatement(base)
//    }
//
//    class IdlingResourceStatement(private val base: Statement?) : Statement() {
//        private val idlingResource = EspressoIdlingResource.countingIdlingResource
//
//        override fun evaluate() {
//            //before
//            IdlingRegistry.getInstance().register(idlingResource)
//            try {
//                base?.evaluate()
//                    ?: throw Exception("Error evaluating test, base statement is null")
//            } finally {
//                //after
//                IdlingRegistry.getInstance().unregister(idlingResource)
//            }
//        }
//    }
//
//}
/*
    option 2:
    easy way but less verbose
 */
class EspressoIdlingResourceRule : TestWatcher() {

    val idlingResource = EspressoIdlingResource.countingIdlingResource

    override fun starting(description: Description?) {
        IdlingRegistry.getInstance().register(idlingResource)
        super.starting(description)
    }

    override fun finished(description: Description?) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }
}