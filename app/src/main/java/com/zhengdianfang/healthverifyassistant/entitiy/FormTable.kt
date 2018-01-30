package com.zhengdianfang.healthverifyassistant.entitiy

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 30/01/2018.
 */
class FormTable {
     companion object {
         val UNFILLED = 0
         val FILLED = 1
         val VERIFYING = 2
         val VERFIY_FAIL = 3
         val VERFIY_SUCCESS = 4
         val CAN_NOT_COMPLETE = 5

     }

    @SerializedName("name")
    var name = ""

    @SerializedName("status")
    var status = 0

    @SerializedName("verifiedPersonCount")
    var verifiedPersonCount = 0

    @SerializedName("members")
    var members: MutableList<MemberTable> = mutableListOf()
}