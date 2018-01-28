package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.ScrollView
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Table

/**
 * Created by dfgzheng on 26/01/2018.
 */
class TableComponent(context: Context, entity: Table) :
        BaseComponent<Table>(context, entity) {
    override fun render(): View {
        val scrollView = ScrollView(context)
        if (entity.page != null) {
            val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            val horizontal = context.resources.getDimension(R.dimen.page_horizontal_margin).toInt()
            val vertical = context.resources.getDimension(R.dimen.page_vertical_margin).toInt()
            layoutParams.setMargins(horizontal, vertical, horizontal, vertical)
            scrollView.addView(PageComponent(context, entity.page!!).render(), layoutParams)
        }
        return scrollView
    }
}