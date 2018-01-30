package com.zhengdianfang.healthverifyassistant.views


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Task
import com.zhengdianfang.healthverifyassistant.views.adapter.TaskInfoAdapter
import kotlinx.android.synthetic.main.fragment_task_info.*
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass.
 */
class TaskInfoFragment : Fragment() {

    var task: Task by Delegates.notNull()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        backButton.setOnClickListener {
            activity.onBackPressed()
        }
        memberListView.adapter = TaskInfoAdapter(task)
    }

}// Required empty public constructor
