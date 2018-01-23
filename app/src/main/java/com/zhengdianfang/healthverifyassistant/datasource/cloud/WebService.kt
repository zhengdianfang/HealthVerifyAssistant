package com.zhengdianfang.healthverifyassistant.datasource.cloud

import com.zhengdianfang.healthverifyassistant.entitiy.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dfgzheng on 20/01/2018.
 * the apis
 */
class WebService {

    companion object {
        val HOST = ""
        val REST_API = Retrofit.Builder().baseUrl(HOST).build()
    }

    interface Api {
        @GET("/login")
        fun login(@Query("phoneNumber") phoneNumber: String, @Query("password") password: String): Call<User>

        @GET("/user")
        fun getUser(@Query("id") id: String): Call<User>
    }
}