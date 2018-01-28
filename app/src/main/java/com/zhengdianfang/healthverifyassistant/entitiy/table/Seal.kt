package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 */
class Seal : Component() {
    companion object {
        val KEY = "seal"
    }
    @SerializedName("label")
    var label: String = ""
}