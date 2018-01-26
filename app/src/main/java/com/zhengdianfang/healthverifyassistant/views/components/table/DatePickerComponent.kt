package com.zhengdianfang.healthverifyassistant.views.components.table

import android.app.DatePickerDialog
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.View
import com.zhengdianfang.healthverifyassistant.entitiy.table.DatePicker
import java.util.*

/**
 * Created by dfgzheng on 25/01/2018.
 */
class DatePickerComponent(context: Context, entity: DatePicker) :
        BaseComponent<DatePicker>(context, entity) {
    val datePickDialog by lazy {
        val calendar = Calendar.getInstance()
        val datePickDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                onDateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickDialog
    }

    val onDateSetListener =
            com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> }

    override fun render(): View {
        val textView = renderTextView(entity)
        textView.setOnClickListener {
            if (context is FragmentActivity) {
                datePickDialog.show((context as FragmentActivity).fragmentManager, "datePicker")
            }
        }
        return textView
    }
}