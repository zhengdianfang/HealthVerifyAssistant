package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Component

/**
 * Created by dfgzheng on 28/01/2018.
 */

class AttachmentComponent(context: Context, entity: Component) : BaseComponent<Component>(context, entity) {

    override fun render(): View {
        val button = Button(context)
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_attachment, 0, 0, 0)
        button.compoundDrawablePadding = context.resources.getDimension(R.dimen.element_margin).toInt()
        button.text = context.resources.getText(R.string.add_attachment_label)
        button.setBackgroundResource(R.drawable.transparent)
        button.textSize = context.resources.getDimension(R.dimen.tableTextSize)
        button.setTextColor(ContextCompat.getColor(context, R.color.tableTextColor))
        return button
    }
}
