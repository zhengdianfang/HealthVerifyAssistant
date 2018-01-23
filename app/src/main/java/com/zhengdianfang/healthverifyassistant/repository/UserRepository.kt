package com.zhengdianfang.healthverifyassistant.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.zhengdianfang.healthverifyassistant.datasource.cloud.WebService
import com.zhengdianfang.healthverifyassistant.entitiy.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by dfgzheng on 20/01/2018.
 */
@Singleton
class UserRepository {

    @Inject
    constructor()

    fun login(phoneNumber: String, password: String) {
        WebService.REST_API.create(WebService.Api::class.java)
                .login(phoneNumber, password)
                .enqueue(object : Callback<User> {
                    override fun onFailure(call: Call<User>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                    }
                })
    }

    fun getUser(id: String): LiveData<User> {
        val data = MutableLiveData<User>()
//        WebService.REST_API.create(WebService.Api::class.java)
//                .getUser(id)
//                .enqueue(object : Callback<User> {
//                    override fun onFailure(call: Call<User>?, t: Throwable?) {
//                    }
//
//                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
//                       data.value = User("1", "1234556677777", "xiaozheng", "123123", "dddddddd")
//                    }
//                })
        data.value = User("1", "1234556677777", "xiaozheng", "123123", "dddddddd")
        return data
    }

}