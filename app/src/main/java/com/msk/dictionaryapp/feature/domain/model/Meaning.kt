package com.msk.dictionaryapp.feature.domain.model

import com.msk.dictionaryapp.feature.data.remote.dto.DefinitionDTO

data class Meaning(val definition: List<Definition>,
                   val partOfSpeech: String)
