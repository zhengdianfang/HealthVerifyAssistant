package com.zhengdianfang.healthverifyassistant.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Member

/**
 * Created by dfgzheng on 30/01/2018.
 */
class MemberAdapter(var members: MutableList<Member>): RecyclerView.Adapter<MemberViewHolder>() {
    override fun getItemCount(): Int {
        return members.count()
    }

    override fun onBindViewHolder(holder: MemberViewHolder?, position: Int) {
        holder?.bindData(members[position], true)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MemberViewHolder {
        return MemberViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.member_item_layout, parent, false))
    }
}