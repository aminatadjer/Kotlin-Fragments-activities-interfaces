package com.example.exo03tdm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task.view.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ToDoList(list : ArrayList<Task>, context : Context) : RecyclerView.Adapter<MyView>() {
    var context:MainActivity = context as MainActivity
    private var taskList =list
    override fun getItemCount(): Int {
        return taskList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val ite = layoutInflater.inflate(R.layout.task, parent, false)
        return MyView(ite)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        holder.itemView.taskName.text = "La tache est: ${taskList[position].taskname} pour le ${sdf.format(taskList[position].taskdate.getTime())}";
        holder.itemView.setOnClickListener{
            try {
                context.taskList.remove(taskList[position])
                taskList.remove(taskList[position])
                notifyItemRemoved(position)
            }catch (e : Exception){}
        }
    }
}