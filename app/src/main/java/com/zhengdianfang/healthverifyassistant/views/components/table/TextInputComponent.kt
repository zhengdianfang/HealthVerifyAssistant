package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.TextInput

/**
 * Created by dfgzheng on 24/01/2018.
 */
class TextInputComponent(context: Context, entity: TextInput) :
        BaseComponent<TextInput>(context, entity) {

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.HORIZONTAL
        val editText = renderEditText()
        editText.hint = entity.placeholder
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.marginStart = context.resources.getDimension(R.dimen.text_margin_start).toInt()

        val textView = renderTextView(entity)
        textView.text = entity.label
        linear.addView(textView)
        linear.addView(editText, layoutParams)
        return linear
    }
}