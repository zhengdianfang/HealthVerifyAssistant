package com.zhengdianfang.healthverifyassistant.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.MemberTable

/**
 * Created by dfgzheng on 30/01/2018.
 */
class MemberTableAdapter(val memberTables: MutableList<MemberTable>): RecyclerView.Adapter<MemberTableViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MemberTableViewHolder {
        return MemberTableViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.member_table_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return memberTables.count()
    }

    override fun onBindViewHolder(holder: MemberTableViewHolder?, position: Int) {
        holder?.bindData(memberTables[position])
    }
}