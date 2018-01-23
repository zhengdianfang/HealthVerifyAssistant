package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 22/01/2018.
 */
class Page: Component() {
    @SerializedName("title")
    var title: String = ""

    @SerializedName("form")
    var form: Form? = null
}