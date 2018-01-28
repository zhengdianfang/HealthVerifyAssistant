package com.zhengdianfang.healthverifyassistant.entitiy.table

import com.google.gson.Gson
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement

/**
 * Created by dfgzheng on 22/01/2018.
 */
class Section: Component() {
    var rows: MutableList<MutableList<out Component>>? = null

    companion object {
        val deserializer = JsonDeserializer<Section> { json, typeOfT, context ->
            val section = Section()
            val sectionObj = json.asJsonObject
            if (sectionObj.has("rows")) {
                val rowsList = mutableListOf<MutableList<out Component>>()
                sectionObj.get("rows").asJsonArray?.forEach {
                    val componentList = mutableListOf<Component>()
                    it.asJsonArray?.forEach { componentElement ->
                        val component = getEntityByType(componentElement)
                        componentList.add(component)
                    }
                    rowsList.add(componentList)
                }
                section.rows = rowsList
            }
            section
        }

        private fun getEntityByType (jsonElement: JsonElement?): Component {
            val gson = Gson()
            var component = Component()
            when(jsonElement?.asJsonObject?.get("type")?.asString) {
                TextInput.KEY ->
                    component = gson.fromJson<TextInput>(jsonElement.toString(), TextInput::class.java)
                CheckBox.KEY ->
                    component = gson.fromJson<CheckBox>(jsonElement.toString(), CheckBox::class.java)
                TextArea.KEY ->
                    component = gson.fromJson<TextArea>(jsonElement.toString(), TextArea::class.java)
                Space.KEY ->
                    component = gson.fromJson<Space>(jsonElement.toString(), Space::class.java)
                StaticText.KEY ->
                    component = gson.fromJson<StaticText>(jsonElement.toString(), StaticText::class.java)
                Signature.KEY ->
                    component = gson.fromJson<Signature>(jsonElement.toString(), Signature::class.java)
                DatePicker.KEY ->
                    component = gson.fromJson<DatePicker>(jsonElement.toString(), DatePicker::class.java)
                Seal.KEY ->
                    component = gson.fromJson<Seal>(jsonElement.toString(), Seal::class.java)
            }
            return component
        }
    }
}