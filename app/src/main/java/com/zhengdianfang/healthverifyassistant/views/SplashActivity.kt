package com.zhengdianfang.healthverifyassistant.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.User
import com.zhengdianfang.healthverifyassistant.entitiy.table.Page
import com.zhengdianfang.healthverifyassistant.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var model: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        model.getUser("1")?.observe(this, Observer<User> {
            textView.text = it?.name
        })

    }
}
