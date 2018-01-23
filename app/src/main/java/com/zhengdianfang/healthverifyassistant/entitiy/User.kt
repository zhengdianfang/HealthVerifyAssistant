package com.zhengdianfang.healthverifyassistant.entitiy

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dfgzheng on 20/01/2018.
 * User POJO
 */
@Entity
data class User(@PrimaryKey var id: String, var phoneNumber: String, var name: String, var companyName: String,
                var address: String)