package com.msk.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.msk.dictionaryapp.feature.data.Util.GsonParser
import com.msk.dictionaryapp.feature.data.local.Converter
import com.msk.dictionaryapp.feature.data.local.WordInfoDAO
import com.msk.dictionaryapp.feature.data.local.wordInfoDatabase
import com.msk.dictionaryapp.feature.data.remote.DictionaryApi
import com.msk.dictionaryapp.feature.domain.repository.WordInfoRepository
import com.msk.dictionaryapp.feature.domain.repository.wordInfoRepositoryImpl
import com.msk.dictionaryapp.feature.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object wordInfoModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository):GetWordInfo= GetWordInfo(repository)

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        api:DictionaryApi,
        dao:WordInfoDAO
    ):WordInfoRepository=wordInfoRepositoryImpl(api,dao)

    @Provides
    @Singleton
    fun provideWordInfoDatabase(
        context:Application
    ):WordInfoDAO{
        val database=Room.databaseBuilder(
            context,wordInfoDatabase::class.java,"wordDB")
            .addTypeConverter(Converter(GsonParser(Gson())))
            .build()
        return database.dao
    }
    @Provides
    @Singleton
    fun provideDictionaryApi():DictionaryApi{
        return Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

}