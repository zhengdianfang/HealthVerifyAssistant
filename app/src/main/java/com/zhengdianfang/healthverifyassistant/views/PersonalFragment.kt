package com.zhengdianfang.healthverifyassistant.views

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import kotlinx.android.synthetic.main.fragment_personal.*


/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
        bindEvents()
    }

    private fun bindEvents() {
        logoutButton.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }

        aboutUsButton.setOnClickListener {
            val fragment = Fragment.instantiate(activity, AboutUsFragment::class.java.name)
            activity?.fragmentManager?.beginTransaction()?.add(android.R.id.content, fragment)
                    ?.addToBackStack("personal")
                    ?.commit()
        }

        feedbackButton.setOnClickListener {
            val fragment = Fragment.instantiate(activity, FeedbackFragment::class.java.name)
            activity?.fragmentManager?.beginTransaction()?.add(android.R.id.content, fragment)
                    ?.addToBackStack("personal")
                    ?.commit()
        }
    }

    private fun initViews() {
        nameTextView.text = getString(R.string.personal_name_label, "韩小雅")
        phoneNumberTextView.text = getString(R.string.personal_phone_label, "15901832473")
        companyTextView.text = getString(R.string.personal_company_label, "北京市海淀区视频药品管理局")
        positionTextView.text = getString(R.string.personal_position_label, "调研科员人员")
        addressTextView.text = getString(R.string.personal_location_label, "北京 北京市 海淀区")
    }

}// Required empty public constructor
