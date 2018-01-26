package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import com.zhengdianfang.healthverifyassistant.entitiy.table.Space

/**
 * Created by dfgzheng on 25/01/2018.
 */
class SpaceComponent(context: Context, entity: Space) :
        BaseComponent<Space>(context, entity) {

    override fun render(): View {
        return android.widget.Space(context)
    }
}