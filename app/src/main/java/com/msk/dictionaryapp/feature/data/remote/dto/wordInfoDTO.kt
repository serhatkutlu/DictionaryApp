package com.msk.dictionaryapp.feature.data.remote.dto

import com.msk.dictionaryapp.feature.domain.model.wordInfo

data class wordInfoDTO(
    val meanings: List<MeaningDTO>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>,
    val word: String
){
    fun toWordInfo():wordInfo{
        return wordInfo(meanings.map { it.toMeaning() }, origin,phonetic, word)
    }
}