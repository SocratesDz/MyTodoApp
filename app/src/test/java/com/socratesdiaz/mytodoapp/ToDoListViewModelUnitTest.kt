package com.socratesdiaz.mytodoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.socratesdiaz.mytodoapp.domain.usecase.ToDoListUseCase
import com.socratesdiaz.mytodoapp.feature.list.ToDoListViewModel
import com.socratesdiaz.mytodoapp.utils.SchedulersFacade
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

class ToDoListViewModelUnitTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun `Fetch list of to-do's`() {
        val todoListUseCase = mock(ToDoListUseCase::class.java)
        `when`(todoListUseCase.loadAllTodos()).thenReturn(Single.just(emptyList()))

        val schedulersFacade = mock(SchedulersFacade::class.java)
        `when`(schedulersFacade.io()).thenReturn(Schedulers.trampoline())
        `when`(schedulersFacade.ui()).thenReturn(Schedulers.trampoline())

        val todoListViewModel = ToDoListViewModel(useCase = todoListUseCase, schedulersFacade = schedulersFacade)
        todoListViewModel.loadAllTodos()
        verify(todoListUseCase).loadAllTodos()
    }
}