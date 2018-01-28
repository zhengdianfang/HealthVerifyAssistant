package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.TextInput
import kotlin.properties.Delegates

/**
 * Created by dfgzheng on 24/01/2018.
 */
class TextInputComponent(context: Context, entity: TextInput) :
        BaseComponent<TextInput>(context, entity), TextWatcher {

    private var editText: EditText by Delegates.notNull<EditText>()

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.HORIZONTAL
        editText = renderEditText()
        editText.addTextChangedListener(this)
        editText.maxLines = 1
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

    override fun afterTextChanged(editable: Editable?) {
        entity.value = editable?.toString() ?: ""
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}