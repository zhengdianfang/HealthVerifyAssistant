package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Component
import com.zhengdianfang.healthverifyassistant.entitiy.table.FontWeight

/**
 * Created by dfgzheng on 24/01/2018.
 */
abstract class BaseComponent<T>(var context: Context, var entity: T) {
    abstract fun render(): View

    open fun renderTextView(entity: Component): TextView {
        val textView = TextView(context)
        textView.textSize = entity.style.getFontSize(context)
        textView.setTextColor(entity.style.getFontColor())
        textView.gravity = entity.style.getAlign()
        when(entity.style.getFontWeight()) {
            FontWeight.BOLD -> textView.setTypeface(null, Typeface.BOLD)
            else -> {
            }
        }

        return textView
    }

    open fun renderEditText(): EditText {
        val editText = EditText(context)
        editText.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        editText.setHintTextColor(ContextCompat.getColor(context, R.color.tableHintTextColor))
        editText.setTextColor(ContextCompat.getColor(context, R.color.tableTextColor))
        return editText
    }

}