package com.zhengdianfang.healthverifyassistant.entitiy

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 30/01/2018.
 */
class Organization {
    @SerializedName("name")
    var name = ""

    val tables: MutableList<FormTable> = mutableListOf()
}