package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.TextArea

/**
 * Created by dfgzheng on 24/01/2018.
 */
class TextAreaComponent(context: Context, entity: TextArea) :
        BaseComponent<TextArea>(context, entity) {

    override fun render(): View {
        val editText = renderEditText()
        editText.setLines(5)
        editText.gravity = Gravity.TOP
        editText.background = ContextCompat.getDrawable(context, R.drawable.default_text_area)
        if (entity.label.isNotBlank()) {
            val linearLayout = LinearLayout(context)
            linearLayout.orientation = LinearLayout.VERTICAL
            val textView = renderTextView(entity)
            textView.text = entity.label
            linearLayout.addView(textView)
            val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.topMargin = context.resources.getDimension(R.dimen.element_margin).toInt()
            linearLayout.addView(editText, layoutParams)
            return  linearLayout
        }
        return editText
    }
}