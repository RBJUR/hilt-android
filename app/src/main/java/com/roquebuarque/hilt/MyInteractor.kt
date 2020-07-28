package com.roquebuarque.hilt

import android.util.Log
import javax.inject.Inject

class MyInteractor @Inject constructor(
    @Impl private val myInterface: MyInterface,
    @Impl2 private val myInterface2: MyInterface
) : MyActions {

    override fun dispatch() {
        Log.d("MyInteractor", "action is dispatched ${myInterface.call()}")
        Log.d("MyInteractor", "action is dispatched ${myInterface2.call()}")
    }
}

interface MyActions{

    fun dispatch()
}