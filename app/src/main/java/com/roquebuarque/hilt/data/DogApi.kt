package com.roquebuarque.hilt.data

import io.reactivex.Observable
import retrofit2.http.GET

interface DogApi {

    @GET("random")
    fun getRandomDog(): Observable<DogDto>

}