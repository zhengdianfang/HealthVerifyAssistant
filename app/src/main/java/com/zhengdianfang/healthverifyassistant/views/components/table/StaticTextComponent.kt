package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.zhengdianfang.healthverifyassistant.entitiy.table.StaticText

/**
 * Created by dfgzheng on 24/01/2018.
 */
class StaticTextComponent(context: Context, entity: StaticText) : BaseComponent<StaticText>(context, entity) {
    override fun render(): View {
        val textView = renderTextView(entity)
        textView.text = entity.text
        return textView
    }
}