package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Signature

/**
 * Created by dfgzheng on 24/01/2018.
 */
class SignatureComponent(context: Context, entity: Signature) :
        BaseComponent<Signature>(context, entity) {

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.HORIZONTAL
        linear.gravity = Gravity.CENTER_VERTICAL
        val textView = renderTextView(entity)
        textView.text = entity.label
        linear.addView(textView)
        linear.addView(renderEditText())
        linear.addView(renderSignatureButton())
        return linear
    }

    override fun renderEditText(): EditText {
        val editText = EditText(context)
        editText.maxLines = 1
        editText.background = ContextCompat.getDrawable(context, R.drawable.default_text_area)
        val layoutParams = LinearLayout.LayoutParams(context.resources.getDimension(R.dimen.signature_edit_width).toInt(),
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.marginStart = context.resources.getDimension(R.dimen.text_margin_start).toInt()
        editText.layoutParams = layoutParams
        return editText
    }

    private fun renderSignatureButton(): ImageButton {
        val button = ImageButton(context)
        button.background = ContextCompat.getDrawable(context, R.drawable.transparent)
        button.setImageResource(R.drawable.ic_signature)
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.marginStart = context.resources.getDimension(R.dimen.text_margin_start).toInt()
        button.layoutParams = layoutParams
        return button
    }
}