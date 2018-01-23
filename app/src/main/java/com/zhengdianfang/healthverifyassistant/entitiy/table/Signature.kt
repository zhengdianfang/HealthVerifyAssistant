package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 */
class Signature : Component() {
    companion object {
        val KEY = "signature"
    }
    @SerializedName("label")
    var label: String = ""
}