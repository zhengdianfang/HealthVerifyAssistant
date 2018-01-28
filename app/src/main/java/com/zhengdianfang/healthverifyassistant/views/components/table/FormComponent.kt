package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.*
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Form

/**
 * Created by dfgzheng on 26/01/2018.
 */
class FormComponent(context: Context, entity: Form) :
        BaseComponent<Form>(context, entity) {

    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.VERTICAL
        val padding = context.resources.getDimension(R.dimen.form_vertical_margin).toInt()
        linear.setPadding(0, padding, 0, padding)
        val layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        entity.sections?.forEachIndexed { index, section ->
            linear.addView(SectionComponent(context, section).render(), index, layoutParams)
        }
        val attachmentButton = AttachmentComponent(context, entity).render()
        linear.addView(attachmentButton, LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT))

        linear.addView(renderSubmitButton(context))
        linear.addView(renderBottomButtons(context))
        return linear
    }

    private fun renderSubmitButton(context: Context): Button {
        val button = Button(context)
        button.setText(R.string.submit_label)
        button.setBackgroundResource(R.drawable.btn_default)
        button.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        val layoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.topMargin = context.resources.getDimension(R.dimen.page_vertical_margin).toInt()
        button.layoutParams = layoutParams
        button.setOnClickListener {
            run breaking@ {
                entity.sections?.forEach {section ->
                    section.rows?.forEach { row->
                        row.forEach {
                            val ok = it.checkValueIsExits(entity)
                            if (!ok) {
                                Toast.makeText(context, it.tip, Toast.LENGTH_SHORT).show()
                                return@breaking
                            }
                        }
                    }
                }
            }
        }
        return button
    }

    private fun renderBottomButtons(context: Context): RelativeLayout {
        val relativeLayout = RelativeLayout(context)
        val resetButton = bottomButton(context, R.drawable.ic_reset, R.string.reset_label)
        val warnButton = bottomButton(context, R.drawable.ic_warn, R.string.warn_label)
        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END)
        relativeLayout.addView(resetButton)
        relativeLayout.addView(warnButton, layoutParams)
        val linearLayoutParams = LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        linearLayoutParams.topMargin = context.resources.getDimension(R.dimen.page_vertical_margin).toInt()
        relativeLayout.layoutParams = linearLayoutParams
        return relativeLayout
    }

    private fun bottomButton(context: Context, leftDrawableId: Int, textId: Int): Button {
        val button = Button(context)
        button.setCompoundDrawablesWithIntrinsicBounds(leftDrawableId, 0, 0, 0)
        button.compoundDrawablePadding = context.resources.getDimension(R.dimen.element_margin).toInt()
        button.text = context.resources.getText(textId)
        button.setBackgroundResource(R.drawable.transparent)
        button.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        button.setTextColor(ContextCompat.getColor(context, R.color.tableTextColor))
        return button
    }
}