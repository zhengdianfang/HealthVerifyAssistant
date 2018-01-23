package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 */

class CheckBox: Component() {

    companion object {
        val KEY = "checkbox"
    }
    @SerializedName("label")
    var label: String = ""
}
