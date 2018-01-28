package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.entitiy.table.Page

/**
 * Created by dfgzheng on 26/01/2018.
 */
class PageComponent(context: Context, entity: Page) :
        BaseComponent<Page>(context, entity) {

    override fun render(): View {
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.addView(renderPageTitle())
        if (null != entity.form) {
            linearLayout.addView(FormComponent(context, entity.form!!).render())
        }
        return linearLayout
    }

    private fun renderPageTitle(): TextView {
        val textView = renderTextView(entity)
        textView.text = entity.title
        textView.gravity = Gravity.CENTER
        return textView
    }
}