package com.socratesdiaz.mytodoapp.feature.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    protected open val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}