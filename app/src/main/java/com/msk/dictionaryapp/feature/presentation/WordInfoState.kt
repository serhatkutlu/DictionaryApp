package com.msk.dictionaryapp.feature.presentation

import com.msk.dictionaryapp.feature.domain.model.wordInfo

data class wordInfoState(
    val wordInfoItem:List<wordInfo> = emptyList(),
    val isloading:Boolean=false
)