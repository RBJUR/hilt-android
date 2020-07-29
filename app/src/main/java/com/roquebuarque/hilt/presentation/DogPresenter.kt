package com.roquebuarque.hilt.presentation

import com.roquebuarque.hilt.base.BasePresenter
import com.roquebuarque.hilt.domain.DogActions
import com.roquebuarque.hilt.domain.DogInteractor
import com.roquebuarque.hilt.domain.DogState
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DogPresenter @Inject constructor(val interactor: DogInteractor)
    : DogActions by interactor, BasePresenter<DogState>(interactor.state)
