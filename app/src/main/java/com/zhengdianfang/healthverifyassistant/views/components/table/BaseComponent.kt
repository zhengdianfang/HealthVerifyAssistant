package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Align
import com.zhengdianfang.healthverifyassistant.entitiy.table.Component
import com.zhengdianfang.healthverifyassistant.entitiy.table.FontWeight

/**
 * Created by dfgzheng on 24/01/2018.
 */
abstract class BaseComponent<T>(var context: Context, var entity: T) {
    abstract fun render(): View

    fun renderTextView(entity: Component): TextView {
        val textView = TextView(context)
        textView.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        textView.setTextColor(ContextCompat.getColor(context, R.color.tableTextColor))
        when(entity.style.getAlign()) {
            Align.LEFT -> textView.gravity = Gravity.LEFT
            Align.RIGHT -> textView.gravity = Gravity.RIGHT
            Align.CENTER -> textView.gravity = Gravity.CENTER
        }
        when(entity.style.getFontWeight()) {
            FontWeight.BOLD -> textView.setTypeface(null, Typeface.BOLD)
            else -> {
            }
        }
        return textView
    }

    fun renderEditText(): EditText {
        val editText = EditText(context)
        editText.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        editText.setHintTextColor(ContextCompat.getColor(context, R.color.tableHintTextColor))
        editText.setTextColor(ContextCompat.getColor(context, R.color.tableTextColor))
        return editText
    }

    fun renderComponentByType(type: String) {
        when(type) {

        }
    }

}