package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 */

class TextArea: Component() {
    companion object {
        val KEY = "textarea"
    }
    @SerializedName("placeholder")
    var placeholder: String = ""

    @SerializedName("label")
    var label: String = ""
}
