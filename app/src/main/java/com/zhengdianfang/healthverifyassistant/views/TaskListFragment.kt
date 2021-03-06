package com.zhengdianfang.healthverifyassistant.views

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.Task
import com.zhengdianfang.healthverifyassistant.views.adapter.TaskAdapter
import kotlinx.android.synthetic.main.fragment_task_list.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TaskListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class TaskListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val gsonBuilder = GsonBuilder()
        val json = resources.openRawResource(R.raw.mock_task_list).bufferedReader().use { it.readText() }
        val taskList = gsonBuilder.create().fromJson<MutableList<Task>>(json , object : TypeToken<MutableList<Task>>(){}.type)
        taskListView.adapter = TaskAdapter(taskList)
    }

}// Required empty public constructor
