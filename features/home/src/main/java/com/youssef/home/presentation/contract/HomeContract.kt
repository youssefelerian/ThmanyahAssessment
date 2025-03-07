package com.youssef.home.presentation.contract

import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.SideEffect
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState


data class HomeUiState(
    override val loadingState: LoadingState? = null,
    override val errorState: ErrorState? = null
) : UiState

sealed interface HomeUiAction : UiAction {

}

sealed interface HomeSideEffect : SideEffect {

}
