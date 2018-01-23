package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 22/01/2018.
 */
class Form: Component(){
    @SerializedName("action")
    var action: String = ""

    @SerializedName("sections")
    var sections: MutableList<Section>? = null
}