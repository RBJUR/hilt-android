package com.roquebuarque.hilt.feature.domain

import android.util.Log
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomButtonInteractor @Inject constructor(){

    fun start(){
        Log.d("Roque", "CustomButtonInteractor started ${this.toString()}")
    }
}