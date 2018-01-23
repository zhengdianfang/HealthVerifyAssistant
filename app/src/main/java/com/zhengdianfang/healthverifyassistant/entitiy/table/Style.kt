package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.annotations.SerializedName

/**
 * Created by dfgzheng on 22/01/2018.
 */
open class Style {
    @SerializedName("flex")
    var flex: Float = 1f

    @SerializedName("text-align")
    var align: String = "left"

    @SerializedName("font-weight")
    var fontWeight: String = ""

    fun getAlign(): Align {
        return Align.valueOf(this.align)
    }

    fun getFontWeight(): FontWeight{
        return FontWeight.valueOf(this.fontWeight)
    }
}

enum class Align(value: String) {
    LEFT("left"),
    RIGHT("right"),
    CENTER("center")
}

enum class FontWeight(value: String) {
    BOLD("bold"),
    NONE("")
}
