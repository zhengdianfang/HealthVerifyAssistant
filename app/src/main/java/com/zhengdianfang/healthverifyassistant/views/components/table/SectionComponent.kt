package com.zhengdianfang.healthverifyassistant.views.components.table

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.GridLayout
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
                val rowLayoutParams = GridLayout.LayoutParams()
                rowLayoutParams.rowSpec = GridLayout.spec(row)
                rowLayoutParams.columnSpec = GridLayout.spec(column, columnEntity.style.flex)
                val span = calSpanSize(columnEntity.style.flex, rowEntity.map { it.style.flex }, rowEntity.size, count)
                rowLayoutParams.columnSpec = GridLayout.spec(column, span,  columnEntity.style.flex)
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
        }
        return component
    }
}