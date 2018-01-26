package com.zhengdianfang.healthverifyassistant.views

import android.app.Activity
import android.os.Bundle
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Table
import com.zhengdianfang.healthverifyassistant.views.components.table.TableComponent
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        val tableView = TableComponent(this, Table.parseJson(resources.openRawResource(R.raw.table_test))).render()
        tableRootView.addView(tableView)
    }
}
