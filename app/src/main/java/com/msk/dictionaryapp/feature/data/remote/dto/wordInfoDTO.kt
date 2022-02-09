package com.msk.dictionaryapp.feature.data.remote.dto

import android.util.Log
import com.msk.dictionaryapp.feature.data.local.entity.WordInfoEntity
import com.msk.dictionaryapp.feature.domain.model.wordInfo

data class wordInfoDTO(
    val meanings: List<MeaningDTO>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>,
    val word: String
){
    fun toWordInfoEntity():WordInfoEntity{


        val a=WordInfoEntity(meanings = meanings.map { it.toMeaning() }, origin = origin, phonetic = phonetic, word = word)

        return a

    }
}