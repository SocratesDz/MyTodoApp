package com.socratesdiaz.mytodoapp.domain.repository

import com.socratesdiaz.mytodoapp.domain.entity.ToDo
import io.reactivex.Single

class ToDoRepositoryImpl(): ToDoRepository {
    override fun fetchAllToDos(): Single<List<ToDo>> {
        return Single.just(emptyList())
    }
}