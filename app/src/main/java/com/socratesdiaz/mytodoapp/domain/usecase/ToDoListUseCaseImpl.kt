package com.socratesdiaz.mytodoapp.domain.usecase

import com.socratesdiaz.mytodoapp.domain.entity.ToDo
import com.socratesdiaz.mytodoapp.domain.repository.ToDoRepository
import io.reactivex.Single

class ToDoListUseCaseImpl(repository: ToDoRepository): ToDoListUseCase {
    override fun loadAllTodos(): Single<List<ToDo>> {
        return Single.just(emptyList())
    }
}