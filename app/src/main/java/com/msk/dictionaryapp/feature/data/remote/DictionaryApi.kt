package com.msk.dictionaryapp.feature.data.remote

import com.msk.dictionaryapp.feature.data.remote.dto.wordInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("entries/en/{word}")
    suspend fun getwordInfo(
        @Path("word")
        word:String

    ):List<wordInfoDTO>

}