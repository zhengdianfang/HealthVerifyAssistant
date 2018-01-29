package com.zhengdianfang.healthverifyassistant.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.zhengdianfang.healthverifyassistant.MainActivity
import com.zhengdianfang.healthverifyassistant.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginTextView.setOnClickListener {
            finish()
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
    }
}
