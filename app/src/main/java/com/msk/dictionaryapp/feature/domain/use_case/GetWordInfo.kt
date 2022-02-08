package com.msk.dictionaryapp.feature.domain.use_case

import com.msk.dictionaryapp.core.util.Resource
import com.msk.dictionaryapp.feature.domain.model.wordInfo
import com.msk.dictionaryapp.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
    ) {
    operator fun invoke(word:String): Flow<Resource<List<wordInfo>>>{
        if (word.isBlank()){
            return flow {  }
        }
        return repository.getwordInfo(word)
    }
}