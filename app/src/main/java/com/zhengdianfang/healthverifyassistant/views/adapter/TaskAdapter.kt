package com.zhengdianfang.healthverifyassistant.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Task

/**
 * Created by dfgzheng on 30/01/2018.
 */
class TaskAdapter(val datas: MutableList<Task>): RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.task_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return datas.count()
    }

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        val task = datas[position]
        holder?.bindData(task)
    }
}