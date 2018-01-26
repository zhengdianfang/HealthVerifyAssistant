package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.zhengdianfang.healthverifyassistant.entitiy.table.Form

/**
 * Created by dfgzheng on 26/01/2018.
 */
class FormComponent(context: Context, entity: Form) :
        BaseComponent<Form>(context, entity) {
    override fun render(): View {
        val linear = LinearLayout(context)
        linear.orientation = LinearLayout.VERTICAL
        linear.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT)
        entity.sections?.forEachIndexed { index, section ->
            linear.addView(SectionComponent(context, section).render(), index)
        }
        return linear
    }
}