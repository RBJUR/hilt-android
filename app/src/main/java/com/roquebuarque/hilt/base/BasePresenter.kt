package com.roquebuarque.hilt.base

import io.reactivex.Observable

open class BasePresenter<State : Any>(val state: Observable<State>)