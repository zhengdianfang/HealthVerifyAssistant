package com.zhengdianfang.healthverifyassistant.entitiy

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 30/01/2018.
 */
class Task {
    @SerializedName("title")
    var title = ""

    @SerializedName("organizations")
    var organizations: MutableList<Organization> = mutableListOf()

    @SerializedName("members")
    var members: MutableList<Member> = mutableListOf()
}