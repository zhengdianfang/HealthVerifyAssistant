package com.zhengdianfang.healthverifyassistant.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Member

/**
 * Created by dfgzheng on 30/01/2018.
 */
class MemberViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private val typeTextView by lazy { itemView?.findViewById<TextView>(R.id.typeTextView)!! }
    private val nameTextView by lazy { itemView?.findViewById<TextView>(R.id.nameTextView)!! }
    private val phoneNumberTextView by lazy { itemView?.findViewById<TextView>(R.id.phoneNumberTextView)!! }
    private val companyTextView by lazy { itemView?.findViewById<TextView>(R.id.companyTextView)!! }
    private val positionTextView by lazy { itemView?.findViewById<TextView>(R.id.positionTextView)!! }
    private val locationTextView by lazy { itemView?.findViewById<TextView>(R.id.locationTextView)!! }

    fun bindData(member: Member, first: Boolean) {
        when (member.type) {
            1 -> typeTextView.setText(R.string.leader_info)
            2 -> typeTextView.setText(R.string.member_info)
        }
        typeTextView.visibility = if (first) View.VISIBLE else View.GONE
        nameTextView.text = itemView?.context?.getString(R.string.personal_name_label, member.name)
        phoneNumberTextView.text = itemView?.context?.getString(R.string.personal_phone_label, member.phoneNumber)
        companyTextView.text = itemView?.context?.getString(R.string.personal_company_label, member.company)
        positionTextView.text = itemView?.context?.getString(R.string.personal_position_label, member.position)
        locationTextView.text = itemView?.context?.getString(R.string.personal_location_label, member.location)
    }
}