package com.msk.dictionaryapp.feature.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

import com.msk.dictionaryapp.feature.data.Util.jsonParser
import com.msk.dictionaryapp.feature.domain.model.Meaning

@ProvidedTypeConverter
class Converter(
    private val jsonParser: jsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(json,
        object :TypeToken<ArrayList<Meaning>>(){}.type ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningJson(meanings:List<Meaning>):String{
        return jsonParser.toJson(meanings,
            object :TypeToken<ArrayList<Meaning>>(){}.type) ?: "[]"
    }
}
