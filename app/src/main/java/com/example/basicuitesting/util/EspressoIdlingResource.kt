package com.example.basicuitesting.util

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE="GLOBAL"

    @JvmStatic val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        countingIdlingResource.increment()
    }
    fun decrement(){
        if (!countingIdlingResource.isIdleNow){
            countingIdlingResource.decrement()
        }
    }
}