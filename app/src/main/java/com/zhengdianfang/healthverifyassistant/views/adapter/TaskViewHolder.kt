package com.zhengdianfang.healthverifyassistant.views.adapter

import android.app.Activity
import android.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.FormTable
import com.zhengdianfang.healthverifyassistant.entitiy.Organization
import com.zhengdianfang.healthverifyassistant.entitiy.Task
import com.zhengdianfang.healthverifyassistant.views.MemberTableListFragment
import com.zhengdianfang.healthverifyassistant.views.TaskInfoFragment

/**
 * Created by dfgzheng on 30/01/2018.
 */
class TaskViewHolder(var view: View): RecyclerView.ViewHolder(view) {
    private val titleTextView by lazy { view.findViewById<TextView>(R.id.taskTitleView) }
    private val organizationListView by lazy { view.findViewById<ViewGroup>(R.id.organizationListView) }

    fun bindData(task: Task) {
        titleTextView.text = task.title
        titleTextView.setOnClickListener {
            if (view.context is Activity) {
                val fragment = Fragment.instantiate(view.context, TaskInfoFragment::class.java.name) as TaskInfoFragment
                fragment.task = task
                (view.context as Activity).fragmentManager
                        .beginTransaction()
                        .add(android.R.id.content, fragment)
                        .addToBackStack("info")
                        .commit()
            }
        }
        organizationListView.removeAllViews()
        task.organizations.forEach {
            organizationListView.addView(initOrganizationList(it))
        }
    }

    private fun initOrganizationList(organization: Organization): View? {
        val organizationView = LayoutInflater.from(view.context).inflate(R.layout.organization_item_layout, null)
        val organizationNameView = organizationView.findViewById<TextView>(R.id.organizationNameView)
        organizationNameView.text = organization.name
        val tableListView = organizationView.findViewById<ViewGroup>(R.id.tableListView)
        val expandView = organizationView.findViewById<CheckBox>(R.id.expandView)
        expandView.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                tableListView.visibility = View.VISIBLE
            } else {
                tableListView.visibility = View.GONE
            }
        }
        organization.tables.forEach { formTable ->
            val tableView = initTableView(formTable)
            tableView?.setOnClickListener {
                val fragment = Fragment.instantiate(view.context, MemberTableListFragment::class.java.name) as MemberTableListFragment
                fragment.formTable = formTable
                (view.context as Activity).fragmentManager
                        .beginTransaction()
                        .add(android.R.id.content, fragment)
                        .addToBackStack("members")
                        .commit()
            }
            tableListView.addView(tableView)
        }
        return organizationView
    }

    private fun initTableView(it: FormTable): View? {
        val tableView = LayoutInflater.from(view.context).inflate(R.layout.table_item_layout, null)
        val tableNameView = tableView.findViewById<TextView>(R.id.tableNameView)
        val verifyPersonCountView = tableView.findViewById<TextView>(R.id.verifyPersonCountView)
        val statusView = tableView.findViewById<TextView>(R.id.statusView)
        tableNameView.text = it.name
        verifyPersonCountView.text = view.context.getString(R.string.people_count, it.verifiedPersonCount)
        val statusBackground = ContextCompat.getDrawable(view.context, R.drawable.table_status_background)
        statusView.background = statusBackground
        when(it.status){
            FormTable.CAN_NOT_COMPLETE -> {
                statusView.text = view.context.getString(R.string.can_not_complete)
                statusBackground?.setTint(ContextCompat.getColor(view.context, android.R.color.darker_gray))
            }
            FormTable.UNFILLED -> {
                statusView.text = view.context.getString(R.string.unfilled)
                statusBackground?.setTint(ContextCompat.getColor(view.context, R.color.unfilled))
            }
            FormTable.FILLED -> {
                statusView.text = view.context.getString(R.string.filled)
                statusBackground?.setTint(ContextCompat.getColor(view.context, R.color.filled))
            }
            FormTable.VERIFYING -> {
                statusView.text = view.context.getString(R.string.vervifying)
                statusBackground?.setTint(ContextCompat.getColor(view.context, R.color.colorAccent))
            }
            FormTable.VERFIY_FAIL -> {
                statusView.text = view.context.getString(R.string.vervify_fail)
                statusBackground?.setTint(ContextCompat.getColor(view.context, R.color.verify_fail))
            }
            FormTable.VERFIY_SUCCESS -> {
                statusView.text = view.context.getString(R.string.vervify_success)
                statusBackground?.setTint(ContextCompat.getColor(view.context, R.color.verify_success))
            }
        }
        return tableView
    }
}