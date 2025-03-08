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
    }

    private fun loadHome() {
        execute {
            getHomeUseCase.collectToMutableState(
                1,
                isFullScreen = true,
                language = "Ar",
                update = { loading, error ->
                    updateUiState { copy(loadingState = loading, errorState = error) }
                },
                success = {
                    updateUiState { copy(loadingState = null, errorState = null, it.toUiModel()) }
                })
        }
    }


}

private fun initialUiState(): HomeUiState =
    HomeUiState(loadingState = LoadingState.FullScreen, null)