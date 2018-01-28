package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.support.v7.widget.GridLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.*

/**
 * Created by dfgzheng on 25/01/2018.
 */
class SectionComponent(context: Context, entity: Section) :
        BaseComponent<Section>(context, entity) {


    override fun render(): View {
        val gridLayout = GridLayout(context)
        val count = entity.rows?.map { it.size }?.max() ?: 1
        gridLayout.columnCount = count
        entity.rows?.forEachIndexed { row, rowEntity ->
            rowEntity.forEachIndexed {column,  columnEntity ->
                val rowLayoutParams = GridLayout.LayoutParams(ViewGroup.LayoutParams(0,
                        ViewGroup.LayoutParams.MATCH_PARENT))

                rowLayoutParams.rowSpec = GridLayout.spec(row, 1f)
                val span = calSpanSize(columnEntity.style.flex, rowEntity.map { it.style.flex }, rowEntity.size, count)
                rowLayoutParams.columnSpec = GridLayout.spec(column, span, columnEntity.style.flex)
                val margin = context.resources.getDimension(R.dimen.element_margin).toInt()
                rowLayoutParams.setMargins(margin, margin, margin, margin)
                rowLayoutParams.setGravity(Gravity.CENTER_VERTICAL)

                val view = getComponentViewByType(columnEntity)
                if (view != null) {
                    Log.d("======", "${columnEntity.type} : ${columnEntity.style.flex} :  $row, $column : $span")
                    gridLayout.addView(view, rowLayoutParams)
                }
            }
        }
        return gridLayout
    }


    private fun calSpanSize(weight: Float, weights: List<Float>,  count: Int, maxCount: Int): Int {
        if (weight == 1f) {
            return maxCount
        }
        if (count < maxCount) {
           if (weight == weights.max() ?: weight) {
              return maxCount - count - 1
           }
        }
        return 1
    }

    private fun getComponentViewByType (entity: Component): View? {
        var component: View? = null
        when(entity.type) {
            TextInput.KEY ->
                component = TextInputComponent(context, entity as TextInput).render()
            CheckBox.KEY ->
                component = CheckBoxComponent(context, entity as CheckBox).render()
            TextArea.KEY ->
                component = TextAreaComponent(context, entity as TextArea).render()
            Space.KEY ->
                component = SpaceComponent(context, entity as Space).render()
            StaticText.KEY ->
                component = StaticTextComponent(context, entity as StaticText).render()
            DatePicker.KEY ->
                component = DatePickerComponent(context, entity as DatePicker).render()
            Signature.KEY ->
                component = SignatureComponent(context, entity as Signature).render()
            Seal.KEY ->
                component = SealComponent(context, entity as Seal).render()
        }
        return component
    }
}