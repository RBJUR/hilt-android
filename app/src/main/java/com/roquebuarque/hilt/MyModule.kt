package com.roquebuarque.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @Singleton
    @Provides
    fun provideMyInterface(): MyInterface{
        return MyInterfaceImpl()
    }
}

