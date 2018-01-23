package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 * The Base Component
 */

open class Component {
    @SerializedName("style")
    var style: Style? = null

    @SerializedName("tip")
    var tip: String? = null

    @SerializedName("value")
    var value: String? = null
}
