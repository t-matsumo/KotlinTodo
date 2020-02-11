package com.gmail.tatsukimatsumo.kotlintodo.tasks

import com.gmail.tatsukimatsumo.kotlintodo.data.Task

interface TasksContract {
    interface View {
        fun update(tasks: Array<Task>)
    }
}