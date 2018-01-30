package com.zhengdianfang.healthverifyassistant.entitiy

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 30/01/2018.
 */
class Member {
    @SerializedName("name")
    var name = ""

    @SerializedName("phoneNumber")
    var phoneNumber = ""

    @SerializedName("company")
    var company = ""

    @SerializedName("position")
    var position = ""

    @SerializedName("location")
    var location = ""

    @SerializedName("type")
    var type = 1
}