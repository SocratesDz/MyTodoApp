package com.socratesdiaz.mytodoapp.utils

import io.reactivex.Scheduler

interface SchedulersFacade {
    fun io(): Scheduler
    fun ui(): Scheduler
}