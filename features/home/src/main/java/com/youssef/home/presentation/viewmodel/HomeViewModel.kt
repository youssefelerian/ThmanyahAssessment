package com.youssef.home.presentation.viewmodel

import com.youssef.base.presntation.viewmodel.BaseViewModel
import com.youssef.base.presntation.viewmodel.delegate
import com.youssef.base.presntation.viewmodel.uimodel.IContract
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.home.domain.interactor.GetHomeUseCase
import com.youssef.home.presentation.contract.HomeSideEffect
import com.youssef.home.presentation.contract.HomeUiAction
import com.youssef.home.presentation.contract.HomeUiState
import com.youssef.home.presentation.ui_mapper.toUiModel
import com.youssef.ui_core.core.collectToMutableState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
) : BaseViewModel(),
    IContract<HomeUiState, HomeUiAction, HomeSideEffect> by delegate(initialUiState()) {

    init {
        loadHome()
    }

    override fun onAction(uiAction: HomeUiAction) {
        when (uiAction) {
            is HomeUiAction.LoadHomeAction -> {
                if (getState().currentHomePage < getState().lastHomePage)
                    loadHome()
            }
        }
    }

    private fun loadHome() {
        execute {
            getHomeUseCase.collectToMutableState(
                getState().currentHomePage,
                isFullScreen = true,
                language = "Ar",
                update = { loading, error ->
                    if (getState().currentHomePage == 1)
                        updateUiState { copy(loadingState = loading, errorState = error) }
                    else if (loading != null)
                        updateUiState { copy(loadingState = LoadingState.LoadMore) }
                },
                success = {
                    updateUiState {
                        copy(
                            loadingState = null, errorState = null,
                            homeList = if (getState().currentHomePage == 1) it.toUiModel() else
                                homeList + it.toUiModel(),
                            lastHomePage = it.pagination.totalPages ?: 1,
                            currentHomePage = getState().currentHomePage + 1
                        )
                    }
                })
        }
    }


}

private fun initialUiState(): HomeUiState =
    HomeUiState(loadingState = LoadingState.FullScreen, null)