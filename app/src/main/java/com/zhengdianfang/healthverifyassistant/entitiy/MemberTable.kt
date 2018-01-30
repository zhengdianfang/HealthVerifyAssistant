package com.zhengdianfang.healthverifyassistant.entitiy

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 30/01/2018.
 */
class MemberTable {

    @SerializedName("name")
    var name = ""

    @SerializedName("organizationName")
    var organizationName = ""

    @SerializedName("status")
    var status = 0
}