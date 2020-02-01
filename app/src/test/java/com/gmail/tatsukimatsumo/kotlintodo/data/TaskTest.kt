package com.gmail.tatsukimatsumo.kotlintodo.data

import android.os.Parcel
import android.os.Parcelable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TaskTest {
    private val titleString = "title"
    private val taskString = "task"
    private lateinit var task: Task

    @Before
    fun setup() {
        task = Task(titleString, taskString)
    }

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

    @Test
    fun testDataIsParcerable() {
        assertTrue(task is Parcelable)
    }
}
