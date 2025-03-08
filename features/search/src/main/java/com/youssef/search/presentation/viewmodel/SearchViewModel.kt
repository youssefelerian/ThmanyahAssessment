package com.youssef.search.presentation.viewmodel

import com.youssef.base.presntation.viewmodel.BaseViewModel
import com.youssef.base.presntation.viewmodel.delegate
import com.youssef.base.presntation.viewmodel.uimodel.IContract
import com.youssef.search.domain.interactor.SearchUseCase
import com.youssef.search.presentation.contract.SearchSideEffect
import com.youssef.search.presentation.contract.SearchUiAction
import com.youssef.search.presentation.contract.SearchUiState
import com.youssef.search.presentation.ui_mapper.toUiModel
import com.youssef.ui_core.core.collectToMutableState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) :
    BaseViewModel(),
    IContract<SearchUiState, SearchUiAction, SearchSideEffect> by delegate(initialUiState()) {

    private val searchFlow = MutableSharedFlow<String>(replay = 1)


    init {
        execute {
            searchFlow
                .distinctUntilChanged()
                .debounce(200)
                .collect { query ->
                    loadSearch(query)
                }
        }
    }

    override fun onAction(uiAction: SearchUiAction) {
        when (uiAction) {
            is SearchUiAction.SearchAction -> {
                searchFlow.tryEmit(uiAction.text)
            }
        }
    }

    private fun loadSearch(text: String) {
        execute {
            searchUseCase.collectToMutableState(
                text,
                isFullScreen = true,
                language = "Ar",
                update = { loading, error ->
                    updateUiState { copy(loadingState = loading, errorState = error) }
                },
                success = {
                    updateUiState {
                        copy(
                            loadingState = null, errorState = null,
                            searchList = it.toUiModel()
                        )
                    }
                })
        }
    }


}

private fun initialUiState(): SearchUiState =
    SearchUiState(loadingState = null, null)