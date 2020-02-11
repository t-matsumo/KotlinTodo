package com.gmail.tatsukimatsumo.kotlintodo.tasks

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.gmail.tatsukimatsumo.kotlintodo.R
import com.gmail.tatsukimatsumo.kotlintodo.data.Task
import kotlinx.android.synthetic.main.layout_task.view.*

class TasksFragment : Fragment(), TasksContract.View {
    private var listener: TasksFragmentListener? = null
    private val mTasksPresenter = TasksPresenter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is TasksFragmentListener) {
            listener = context
        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
            ?.let { if (it is RecyclerView) it else null }
            ?.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ItemAdapter(arrayOf(
                    Task("aa", "aa"),
                    Task("bb", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"),
                    Task("cc", "cc")))
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mTasksPresenter.onViewCreated()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun update(tasks: Array<Task>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface TasksFragmentListener {
        fun onTapTask()
    }

    class ItemAdapter(val datas: Array<Task>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
        // Each data item is just a string in this case that is shown in a TextView.
        class MyViewHolder(val taskLayout: View, val titleView: TextView, val taskView: TextView) : RecyclerView.ViewHolder(taskLayout)

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): ItemAdapter.MyViewHolder {
            // create a new view
            return LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_task, parent, false)
                .let { MyViewHolder(it, it.title, it.task) }
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.titleView.text = datas[position].title
            holder.taskView.text = datas[position].task
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = datas.size

    }
}
