package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.CheckBox

/**
 * Created by dfgzheng on 24/01/2018.
 */
class CheckBoxComponent(context: Context, entity: CheckBox) :
        BaseComponent<CheckBox>(context, entity) {

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.HORIZONTAL
        linear.gravity = Gravity.CENTER_VERTICAL
        val textView = renderTextView(entity)
        textView.text = entity.label
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.marginStart = context.resources.getDimension(R.dimen.text_margin_start).toInt()
        val checkbox = android.widget.CheckBox(context)
        linear.addView(checkbox)
        linear.addView(textView, layoutParams)
        return linear
    }
}