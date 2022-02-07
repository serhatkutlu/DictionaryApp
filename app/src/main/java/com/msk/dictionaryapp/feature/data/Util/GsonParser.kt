package com.msk.dictionaryapp.feature.data.Util

import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParser(
    private val gson: Gson
):jsonParser{
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json,type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj,type)
    }

}