package com.roquebuarque.hilt

import javax.inject.Inject

class MyInterfaceImpl2 @Inject constructor() : MyInterface {

    override fun call() : String {
       return "doing a call"
    }

}