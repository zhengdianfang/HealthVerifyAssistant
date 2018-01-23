package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 */
class TextInput: Component() {
    companion object {
        val KEY = "textbox"
    }

    @SerializedName("label")
    var label: String = ""
    @SerializedName("placeholder")
    var placeholder: String = ""
}
