package com.msk.dictionaryapp.feature.data.remote.dto

import com.msk.dictionaryapp.feature.domain.model.Definition
import com.msk.dictionaryapp.feature.domain.model.Meaning

data class MeaningDTO(
    val definition: List<DefinitionDTO>,
    val partOfSpeech: String
){
    fun toMeaning():Meaning{
        return Meaning(definition = definition.map { it.toDefinition() },partOfSpeech)
    }
}