package com.roquebuarque.hilt.feature.presentation

import com.roquebuarque.hilt.base.BasePresenter
import com.roquebuarque.hilt.feature.domain.DogActions
import com.roquebuarque.hilt.feature.domain.DogInteractor
import com.roquebuarque.hilt.feature.domain.DogState
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DogPresenter @Inject constructor(val interactor: DogInteractor)
    : DogActions by interactor, BasePresenter<DogState>(interactor.state)
