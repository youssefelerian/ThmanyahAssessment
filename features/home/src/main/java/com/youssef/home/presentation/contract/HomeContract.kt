package com.youssef.home.presentation.contract

import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.SideEffect
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState
import com.youssef.uikit.ui_model.IRenderComponent


data class HomeUiState(
    override val loadingState: LoadingState? = null,
    override val errorState: ErrorState? = null,
    val homeList: List<IRenderComponent> = listOf(),
    val currentHomePage: Int = 1,
    val lastHomePage: Int = 1
) : UiState

sealed interface HomeUiAction : UiAction {
    data object LoadHomeAction : HomeUiAction
}

sealed interface HomeSideEffect : SideEffect
