package com.socratesdiaz.mytodoapp.domain.usecase

import com.socratesdiaz.mytodoapp.domain.entity.ToDo
import io.reactivex.Single

interface ToDoListUseCase {
    fun loadAllTodos(): Single<List<ToDo>>
}