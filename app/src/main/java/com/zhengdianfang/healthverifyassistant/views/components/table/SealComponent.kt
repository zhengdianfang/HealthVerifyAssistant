package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Seal

/**
 * Created by dfgzheng on 24/01/2018.
 */
class SealComponent(context: Context, entity: Seal) :
        BaseComponent<Seal>(context, entity) {

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.HORIZONTAL
        linear.gravity = entity.style.getAlign()
        val textView = renderTextView(entity)
        textView.text = entity.label
        linear.addView(textView)
        linear.addView(renderSignatureButton())
        return linear
    }

    private fun renderSignatureButton(): ImageButton {
        val button = ImageButton(context)
        button.background = ContextCompat.getDrawable(context, R.drawable.transparent)
        button.setImageResource(R.drawable.ic_seal)
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.marginStart = context.resources.getDimension(R.dimen.text_margin_start).toInt()
        button.layoutParams = layoutParams
        return button
    }
}