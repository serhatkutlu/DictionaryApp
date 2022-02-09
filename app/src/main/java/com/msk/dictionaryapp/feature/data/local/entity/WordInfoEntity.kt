package com.msk.dictionaryapp.feature.data.local.entity

import android.util.Log
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.msk.dictionaryapp.feature.domain.model.Meaning
import com.msk.dictionaryapp.feature.domain.model.wordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val meanings: List<Meaning>,
    val origin: String?,
    val phonetic: String?,
    val word: String
){
    fun toWordInfo():wordInfo{

        val a= wordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic)

        return a
    }
}
