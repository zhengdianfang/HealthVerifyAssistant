package com.zhengdianfang.healthverifyassistant.entitiy.table

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
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

    @SerializedName("font-size")
    var fontSize: Int = 16

    @SerializedName("font-color")
    var fontColor: String = "#333333"

    fun getAlign(): Int {
        var enum = Gravity.LEFT
        when(this.align) {
            "left" -> enum = Gravity.LEFT
            "right" -> enum = Gravity.RIGHT
            "center" -> enum = Gravity.CENTER
        }
        return enum
    }

    fun getFontWeight(): FontWeight{
        var enum = FontWeight.NONE
        when(this.fontWeight) {
            "bold" -> enum = FontWeight.BOLD
        }
        return enum
    }

    fun getFontColor(): Int {
        return Color.parseColor(this.fontColor)
    }

    fun getFontSize(context: Context): Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.fontSize.toFloat(), context.resources.displayMetrics)
    }
}
enum class FontWeight {
    BOLD,
    NONE
}
