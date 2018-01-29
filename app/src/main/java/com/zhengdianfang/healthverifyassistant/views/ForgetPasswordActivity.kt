package com.zhengdianfang.healthverifyassistant.views

import android.app.Activity
import android.os.Bundle
import com.zhengdianfang.healthverifyassistant.R
import kotlinx.android.synthetic.main.activity_forget_password.*

class ForgetPasswordActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        loginTextView.setOnClickListener {
            finish()
        }
    }
}
