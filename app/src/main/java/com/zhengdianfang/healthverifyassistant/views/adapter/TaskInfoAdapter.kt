package com.zhengdianfang.healthverifyassistant.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Task

/**
 * Created by dfgzheng on 30/01/2018.
 */
class TaskInfoAdapter(val task: Task): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val HEAD_TYPE  = 0
        val MEMEBR_TYPE  = 1
    }
    val memberAdapter by lazy { MemberAdapter(task.members) }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HEAD_TYPE) {
            return object : RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.task_info_header_layout, parent, false)) {}
        }
        return memberAdapter.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return 1 + memberAdapter.itemCount
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
           return HEAD_TYPE
        }
        return MEMEBR_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == HEAD_TYPE) {
            val taskNameTextView = holder?.itemView?.findViewById<TextView>(R.id.taskNameTextView)!!
            val organizationNameTextView = holder?.itemView?.findViewById<TextView>(R.id.organizationNameTextView)!!
            taskNameTextView.text = task.title
            val organizationNames = task.organizations.map { it.name }.joinToString("\n")
            organizationNameTextView.text = organizationNames
        } else {
            memberAdapter.onBindViewHolder(holder as MemberViewHolder?, position - 1)
        }
    }
}