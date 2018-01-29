package com.zhengdianfang.healthverifyassistant.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhengdianfang.healthverifyassistant.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        run {
            Thread.sleep(3000)
            runOnUiThread {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        }
    }
}
