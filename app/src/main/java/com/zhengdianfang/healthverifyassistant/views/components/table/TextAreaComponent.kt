package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.view.View
import com.zhengdianfang.healthverifyassistant.entitiy.table.StaticText
import com.zhengdianfang.healthverifyassistant.entitiy.table.TextArea

/**
 * Created by dfgzheng on 24/01/2018.
 */
class TextAreaComponent(context: Context, entity: TextArea) :
        BaseComponent<TextArea>(context, entity) {

    override fun render(): View {
        val editText = renderEditText()
        editText.setLines(5)
        return editText
    }
}