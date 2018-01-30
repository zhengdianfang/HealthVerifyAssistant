package com.zhengdianfang.healthverifyassistant.views.adapter

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.FormTable
import com.zhengdianfang.healthverifyassistant.entitiy.MemberTable
import com.zhengdianfang.healthverifyassistant.views.TableActivity

/**
 * Created by dfgzheng on 30/01/2018.
 */
class MemberTableViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView by lazy { itemView?.findViewById<TextView>(R.id.nameTextView)!! }
    private val organizationNameTextView by lazy { itemView?.findViewById<TextView>(R.id.organizationNameTextView)!! }
    private val statusView by lazy { itemView?.findViewById<TextView>(R.id.statusView)!! }


    fun bindData(memberTable: MemberTable) {
        itemView.setOnClickListener {
            itemView?.context?.startActivity(Intent(itemView.context, TableActivity::class.java))
        }
        nameTextView.text = memberTable.name
        organizationNameTextView.text = memberTable.organizationName
        when(memberTable.status){
            FormTable.CAN_NOT_COMPLETE -> {
                statusView.text = itemView.context.getString(R.string.can_not_complete)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.darker_gray))
            }
            FormTable.UNFILLED -> {
                statusView.text = itemView.context.getString(R.string.unfilled)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, R.color.unfilled))
            }
            FormTable.FILLED -> {
                statusView.text = itemView.context.getString(R.string.filled)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, R.color.filled))
            }
            FormTable.VERIFYING -> {
                statusView.text = itemView.context.getString(R.string.vervifying)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            }
            FormTable.VERFIY_FAIL -> {
                statusView.text = itemView.context.getString(R.string.vervify_fail)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, R.color.verify_fail))
            }
            FormTable.VERFIY_SUCCESS -> {
                statusView.text = itemView.context.getString(R.string.vervify_success)
                statusView.setTextColor(ContextCompat.getColor(itemView.context, R.color.verify_success))
            }
        }
    }
}