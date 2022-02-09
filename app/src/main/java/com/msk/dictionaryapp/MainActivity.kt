package com.msk.dictionaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.msk.dictionaryapp.feature.presentation.wordInfoItem
import com.msk.dictionaryapp.feature.presentation.wordInfoViewModel
import com.msk.dictionaryapp.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryAppTheme {
                val viewModel: wordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()
                LaunchedEffect(key1 = true) {
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is wordInfoViewModel.UIEvent.ShowSnackbar -> {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }

                    }
                }

                Scaffold(scaffoldState = scaffoldState) {
                    Box(modifier = Modifier.background(MaterialTheme.colors.background)) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextField(value = viewModel.searchQuery.value,
                                onValueChange =viewModel::onsearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search...")
                                })

                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(state.wordInfoItem.size) { i ->
                                val wordInfo = state.wordInfoItem[i]
                                if (i > 0) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                                wordInfoItem(wordInfo = wordInfo)
                                if (i < state.wordInfoItem.size - 1) {
                                    Divider()
                                }

                            }
                        }}
                        if (state.isloading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    }
                }
            }
        }
    }
}
