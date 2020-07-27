package com.roquebuarque.hilt

import android.util.Log
import javax.inject.Inject

class MyInteractor @Inject constructor(private val myInterface: MyInterface): MyActions {

    override fun dispatch() {
        Log.d("MyInteractor", "action is dispatched ${myInterface.call()}")
    }
}

interface MyActions{

    fun dispatch()
}