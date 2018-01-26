package com.zhengdianfang.healthverifyassistant.entitiy.table

import android.util.Log
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
        var enum = Align.LEFT
        when(this.align) {
            "left" -> enum = Align.LEFT
            "right" -> enum = Align.RIGHT
            "center" -> enum = Align.CENTER
        }
        return enum
    }

    fun getFontWeight(): FontWeight{
        var enum = FontWeight.NONE
        when(this.align) {
            "bold" -> enum = FontWeight.BOLD
        }
        return enum
    }
}

enum class Align {
    LEFT,
    RIGHT,
    CENTER
}

enum class FontWeight {
    BOLD,
    NONE
}
