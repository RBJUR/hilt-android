package com.roquebuarque.hilt.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.roquebuarque.hilt.feature.data.DogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDogApi(retrofit: Retrofit): DogApi {
        return retrofit
            .create(DogApi::class.java)
    }

}