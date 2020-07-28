package com.roquebuarque.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @Impl
    @Singleton
    @Provides
    fun provideMyInterface(): MyInterface{
        return MyInterfaceImpl()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideMyInterface2(): MyInterface{
        return MyInterfaceImpl2()
    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2

//Check
/*
AnnotationRetention.BINARY
AnnotationRetention.RUNTIME
AnnotationRetention.SOURCE
 */

