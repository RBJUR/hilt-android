package com.roquebuarque.hilt.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidApp
class MyApplication: Application() {

    @Inject lateinit var abc: ABC
}

@Singleton
class ABC @Inject constructor()