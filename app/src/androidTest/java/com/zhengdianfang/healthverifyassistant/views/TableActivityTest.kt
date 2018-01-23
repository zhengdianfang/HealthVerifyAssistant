package com.zhengdianfang.healthverifyassistant.views

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.google.gson.GsonBuilder
import com.zhengdianfang.healthverifyassistant.R
import com.zhengdianfang.healthverifyassistant.entitiy.table.Section
import com.zhengdianfang.healthverifyassistant.entitiy.table.Table
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by dfgzheng on 23/01/2018.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class TableActivityTest {
    @Rule
    @JvmField
    val tableActivity = ActivityTestRule<TableActivity>(TableActivity::class.java)

    @Test
    fun test_parse_json_to_page_pojo() {
        val tableObject = Table.parseJson(tableActivity.activity
                .resources.openRawResource(R.raw.table_test))
        assert(tableObject.page?.title == "食品药品合规检查表")
    }
}