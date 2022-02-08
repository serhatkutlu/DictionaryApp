package com.msk.dictionaryapp.feature.domain.repository

import com.msk.dictionaryapp.core.util.Resource
import com.msk.dictionaryapp.feature.domain.model.wordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getwordInfo(word:String): Flow<Resource<List<wordInfo>>>
}