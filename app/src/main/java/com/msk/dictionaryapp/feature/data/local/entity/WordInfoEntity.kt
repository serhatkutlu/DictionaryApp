package com.msk.dictionaryapp.feature.data.local.entity

import androidx.room.Entity
import com.msk.dictionaryapp.feature.domain.model.Meaning
import com.msk.dictionaryapp.feature.domain.model.wordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
){
    fun toWordInfo():wordInfo{
        return wordInfo(meanings, origin, phonetic,word)
    }
}
