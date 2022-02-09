package com.msk.dictionaryapp.feature.data.remote.dto

import android.util.Log
import com.msk.dictionaryapp.feature.domain.model.Definition
import com.msk.dictionaryapp.feature.domain.model.Meaning

data class MeaningDTO(
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String
){
    fun toMeaning():Meaning{

        val def=definitions.map{it.toDefinition() }
        val speech=partOfSpeech

        return Meaning(definition = def, partOfSpeech = speech)
    }
}