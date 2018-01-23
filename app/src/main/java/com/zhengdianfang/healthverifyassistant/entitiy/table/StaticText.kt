package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 * The only text component
 */

class StaticText: Component() {
    companion object {
        val KEY = "static"
    }
    @SerializedName("label")
    var text: String = ""
}
