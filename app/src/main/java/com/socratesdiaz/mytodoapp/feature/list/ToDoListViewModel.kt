package com.socratesdiaz.mytodoapp.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.socratesdiaz.mytodoapp.domain.entity.ToDo
import com.socratesdiaz.mytodoapp.domain.usecase.ToDoListUseCase
import com.socratesdiaz.mytodoapp.feature.base.BaseViewModel
import com.socratesdiaz.mytodoapp.utils.Event
import com.socratesdiaz.mytodoapp.utils.SchedulersFacade
import io.reactivex.observers.DisposableSingleObserver

class ToDoListViewModel(private val useCase: ToDoListUseCase,
                        private val schedulersFacade: SchedulersFacade): BaseViewModel() {
    private val _todos = MutableLiveData<List<ToDo>>()

    val todos: LiveData<List<ToDo>>
        get() = _todos

    private val _errorMessage = MutableLiveData<Event<String>>()

    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage


    fun loadAllTodos() {
        disposables.add(useCase.loadAllTodos()
            .subscribeOn(schedulersFacade.io())
            .observeOn(schedulersFacade.ui())
            .subscribeWith(object : DisposableSingleObserver<List<ToDo>>() {
                override fun onSuccess(todos: List<ToDo>) {
                    _todos.value = todos
                }

                override fun onError(e: Throwable) {
                    _errorMessage.value = Event(e.message ?: "")
                }
            }))
    }
}