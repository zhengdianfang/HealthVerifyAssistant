package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import com.zhengdianfang.healthverifyassistant.entitiy.table.Table

/**
 * Created by dfgzheng on 26/01/2018.
 */
class TableComponent(context: Context, entity: Table) :
        BaseComponent<Table>(context, entity) {
    override fun render(): View {
        return entity.page?.let { PageComponent(context, it).render() } ?: View(context)
    }
}