package com.socratesdiaz.mytodoapp.domain.repository

import com.socratesdiaz.mytodoapp.domain.entity.ToDo
import io.reactivex.Single

interface ToDoRepository {
    fun fetchAllToDos(): Single<List<ToDo>>
}