package com.msk.dictionaryapp.feature.domain.repository

import com.msk.dictionaryapp.core.util.Resource
import com.msk.dictionaryapp.feature.data.local.WordInfoDAO
import com.msk.dictionaryapp.feature.data.remote.DictionaryApi
import com.msk.dictionaryapp.feature.domain.model.wordInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class wordInfoRepositoryImpl(
    private val api:DictionaryApi,
    private val dao:WordInfoDAO
):WordInfoRepository{
    override fun getwordInfo(word: String): Flow<Resource<List<wordInfo>>> = flow {
        emit(Resource.Loading())
        val wordinfo=dao.getWordInfos(word).map{it.toWordInfo()}
        emit(Resource.Loading(wordinfo))

        try {
            val remoteWordsInfo=api.getwordInfo(word)
            dao.deleteWord(remoteWordsInfo.map { it.word })
            dao.insertWordInfos(remoteWordsInfo.map { it.toWordInfoEntitiy() })
        }
        catch (e:HttpException){
            emit(Resource.Error("something went wrong",wordinfo))
        }
        catch (e:IOException){
            emit(Resource.Error("couldn't reach server ,check your internet connection",wordinfo))

        }
        val newWordInfo=dao.getWordInfos(word) .map { it.toWordInfo() }
    }

}