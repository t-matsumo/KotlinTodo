package com.gmail.tatsukimatsumo.kotlintodo.tasks

import com.gmail.tatsukimatsumo.kotlintodo.data.Task

class TasksPresenter(val mView: TasksContract.View) {
    fun onViewCreated() {
        mView.update(
            arrayOf(Task("", ""))
        )
    }
}