package com.msk.dictionaryapp.feature.presentation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msk.dictionaryapp.feature.domain.model.wordInfo



@Composable
fun wordInfoItem(
    wordInfo:wordInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier=modifier) {
        Text(text = wordInfo.word, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
        Spacer(modifier=Modifier.height(16.dp))
        Text(text = wordInfo.origin)
        
        wordInfo.meanings.forEach{
            Text(text = it.partOfSpeech, fontWeight = FontWeight.Bold)
            it.definition.forEachIndexed{index,definition->
                Text(text = "${index+1}.${definition.definition}")
                Spacer(modifier =Modifier.height(8.dp))
                definition.example?.let{exam->
                    Text(text = "Example: $exam")

                }
                Spacer(modifier = Modifier.height(8.dp))

            }
            Spacer(modifier = Modifier)
        }
    }

}