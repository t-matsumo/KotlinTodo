package com.gmail.tatsukimatsumo.kotlintodo.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class TaskTest {
    private val titleString = "title"
    private val taskString = "task"
    private val task = Task(titleString, taskString)

    @Test
    fun testSetCollectData() {
        assertEquals(titleString, task.title)
        assertEquals(taskString, task.task)
    }

    @Test
    fun testDataEquality() {
        assertEquals(Task(titleString, taskString), task)
        assertNotEquals(Task(titleString, "not same task"), task)
        assertNotEquals(Task("not same title", taskString), task)
        assertNotEquals(Task("not same title", "not same task"), task)
    }
}
