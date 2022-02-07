package com.msk.dictionaryapp.feature.domain.model

import com.msk.dictionaryapp.feature.data.remote.dto.MeaningDTO
import com.msk.dictionaryapp.feature.data.remote.dto.PhoneticDTO

data class wordInfo(val meanings: List<Meaning>,
                    val origin: String,
                    val phonetic: String,
                    val word: String) {
}