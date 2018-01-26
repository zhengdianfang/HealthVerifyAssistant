package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.ScrollView
import com.zhengdianfang.healthverifyassistant.entitiy.table.Page

/**
 * Created by dfgzheng on 26/01/2018.
 */
class PageComponent(context: Context, entity: Page) :
        BaseComponent<Page>(context, entity) {

    override fun render(): View {
        val scrollView = ScrollView(context)
        if (entity.form != null) {
            scrollView.addView(FormComponent(context, entity.form!!).render())
        }
        return scrollView
    }
}