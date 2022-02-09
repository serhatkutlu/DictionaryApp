package com.msk.dictionaryapp.feature.data.remote.dto

import android.util.Log
import com.msk.dictionaryapp.feature.domain.model.Definition

data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){
    fun toDefinition():Definition{


        val a= Definition(antonyms = antonyms, definition = definition, example=example, synonyms=synonyms)

        return a
    }
}