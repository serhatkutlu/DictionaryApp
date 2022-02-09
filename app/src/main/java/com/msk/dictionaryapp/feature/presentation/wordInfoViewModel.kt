package com.msk.dictionaryapp.feature.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msk.dictionaryapp.core.util.Resource
import com.msk.dictionaryapp.feature.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class wordInfoViewModel @Inject constructor(
    private val getwordInfo:GetWordInfo
):ViewModel(){

    private val _searchQuery= mutableStateOf("")
    val searchQuery:State<String> =_searchQuery

    private val _state= mutableStateOf(wordInfoState())
    val state:State<wordInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow= _eventFlow.asSharedFlow()

    private var searchjob:Job?=null

    fun onsearch(query:String){
    _searchQuery.value=query
        searchjob?.cancel()
        searchjob=viewModelScope.launch {
            delay(500L)
            getwordInfo(query).onEach {
                when(it){
                    is Resource.Succes->{

                        _state.value=state.value.copy(
                            it.data ?: emptyList(),
                            false
                        )

                    }
                    is Resource.Loading->{

                        _state.value=state.value.copy(
                            it.data ?: emptyList(),
                            false
                        )
                    }
                    is Resource.Error->{

                        _state.value=state.value.copy(
                            it.data ?: emptyList(),
                            false
                        )
                        _eventFlow.emit(UIEvent.ShowSnackbar(it.message ?: "Unknown Error"))
                    }

                }
            }.launchIn(this)
        }

    }
    sealed class UIEvent{
        data class ShowSnackbar(val message:String):UIEvent()
    }


}