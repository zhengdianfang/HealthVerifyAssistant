package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.InputStream
import kotlin.properties.Delegates

/**
 * Created by dfgzheng on 23/01/2018.
 */
class Table {
    @SerializedName("page")
    var page: Page? = null

    companion object {

        fun parseJson(inputStream: InputStream): Table{
            val gsonBuilder = GsonBuilder()
            gsonBuilder.registerTypeAdapter(Section::class.java, Section.deserializer)
            val json = inputStream.bufferedReader().use { it.readText() }
            return gsonBuilder.create().fromJson<Table>(json ,Table::class.java)
        }
    }
}