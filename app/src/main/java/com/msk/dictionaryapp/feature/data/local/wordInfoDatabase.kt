package com.msk.dictionaryapp.feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.msk.dictionaryapp.feature.data.local.entity.WordInfoEntity


@Database(
    entities = [WordInfoEntity::class], version = 1
)
@TypeConverters(Converter::class)
abstract class wordInfoDatabase:RoomDatabase() {
    abstract val dao:WordInfoDAO
}