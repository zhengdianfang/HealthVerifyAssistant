package com.zhengdianfang.healthverifyassistant.views


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zhengdianfang.healthverifyassistant.R
import kotlinx.android.synthetic.main.fragment_about_us.*


/**
 * A simple [Fragment] subclass.
 */
class AboutUsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        versionTextView.text = activity?.packageManager?.getPackageInfo(activity?.packageName, 0)?.versionName
        backButton.setOnClickListener {
            activity.onBackPressed()
        }
    }

}// Required empty public constructor
