package com.zhengdianfang.healthverifyassistant.entitiy.table

import android.text.TextUtils
import com.google.gson.annotations.SerializedName
/**
 * Created by dfgzheng on 22/01/2018.
 * The Base Component
 */

open class Component {
    @SerializedName("style")
    var style: Style = Style()

    @SerializedName("tip")
    var tip: String = ""

    @SerializedName("value")
    var value: String = ""

    @SerializedName("type")
    var type = ""

    open fun checkValueIsExits(entity: Component): Boolean {
        return !TextUtils.isEmpty(value) && !TextUtils.isEmpty(entity.tip)
    }
}
