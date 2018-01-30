package com.zhengdianfang.healthverifyassistant.views


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.FormTable
import com.zhengdianfang.healthverifyassistant.views.adapter.MemberTableAdapter
import kotlinx.android.synthetic.main.fragment_member_table_list.*
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass.
 */
class MemberTableListFragment : Fragment() {

    var formTable by Delegates.notNull<FormTable>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_table_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        toolbarTitleView.text = formTable.name

        tableListView.adapter = MemberTableAdapter(formTable.members)
    }

}// Required empty public constructor
