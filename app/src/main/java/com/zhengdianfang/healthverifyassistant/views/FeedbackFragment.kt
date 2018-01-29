package com.zhengdianfang.healthverifyassistant.views


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.zhengdianfang.healthverifyassistant.R
import kotlinx.android.synthetic.main.fragment_feedback.*


/**
 * A simple [Fragment] subclass.
 */
class FeedbackFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backButton.setOnClickListener {
            activity.onBackPressed()
        }

        submitButton.setOnClickListener {
            Toast.makeText(activity.baseContext, R.string.submit_success_toast, Toast.LENGTH_SHORT).show()
            activity.onBackPressed()
        }
    }

}// Required empty public constructor
