package com.roquebuarque.hilt.feature.domain

import com.roquebuarque.hilt.base.BaseState
import com.roquebuarque.hilt.feature.data.DogRepository
import com.roquebuarque.hilt.feature.domain.DogEvent.Fetch
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogInteractor @Inject constructor(private val repository: DogRepository) : DogActions {

    private val stateSubject = PublishSubject.create<DogEvent>()

    val state : Observable<DogState> = stateSubject
        .hide()
        .switchMap { processEvent(it) }

    override fun dispatch(event: DogEvent) {
        stateSubject.onNext(event)
    }

    private fun processEvent(event: DogEvent): Observable<DogState> {
       return when (event) {
            is Fetch -> {
                repository
                    .getRandomDog()
                    .map { dog -> DogState(isLoading = false, image = dog.image) }
                    .onErrorReturn {
                        DogState(
                            isLoading = false,
                            error = "Something went wrong, please try again!"
                        )
                    }
                    .startWith(DogState(isLoading = true))
            }
           //else -> throw IllegalArgumentException("Unknown event $event")
        }
    }
}


interface DogActions {

    fun dispatch(event: DogEvent)

}

/**
 * List of events to update the ui
 */
sealed class DogEvent {

    /**
     * Fetch dog from remote
     */
    object Fetch : DogEvent()
}

/**
 * Data class that store the dog state
 */
data class DogState(val isLoading: Boolean, val image: String = "", val error: String = ""): BaseState()