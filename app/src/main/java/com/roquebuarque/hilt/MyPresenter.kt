package com.roquebuarque.hilt

import javax.inject.Inject

class MyPresenter @Inject constructor(private val interactor: MyInteractor) : MyActions by interactor {


}

