package com.gmail.tatsukimatsumo.kotlintodo.data

import android.os.Parcel
import android.os.Parcelable

data class Task(val title: String, val task: String) : Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.apply {
            writeString(title)
            writeString(task)
        }
    }

    override fun describeContents(): Int = 0

    companion object {
        @Suppress("unused")
        @JvmField
        val CREATOR: Parcelable.Creator<Task> = object: Parcelable.Creator<Task> {
            override fun createFromParcel(source: Parcel?): Task {
                val title = source!!.readString()!!
                val task = source!!.readString()!!
                return Task(title, task)
            }

            override fun newArray(size: Int): Array<Task?> = arrayOfNulls(size)
        }
    }
}