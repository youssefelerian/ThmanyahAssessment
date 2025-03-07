package com.youssef.home.presentation.contract

import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.SideEffect
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState
import com.youssef.home.domain.entity.HomeEntity


data class HomeUiState(
    override val loadingState: LoadingState? = null,
    override val errorState: ErrorState? = null,
    val home: HomeEntity? = null
) : UiState

sealed interface HomeUiAction : UiAction {
    data object LoadHomeAction : HomeUiAction
}

sealed interface HomeSideEffect : SideEffect
