package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 22/01/2018.
 */

class DatePicker: Component() {
    companion object {
        val KEY = "date"
    }
    @SerializedName("label")
    var label: String = ""
}
