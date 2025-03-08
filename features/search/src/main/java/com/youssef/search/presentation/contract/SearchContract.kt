package com.youssef.search.presentation.contract

import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.SideEffect
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState
import com.youssef.uikit.ui_model.IRenderComponent


data class SearchUiState(
    override val loadingState: LoadingState? = null,
    override val errorState: ErrorState? = null,
    val searchList: List<IRenderComponent> = listOf()
) : UiState

sealed interface SearchUiAction : UiAction {
    data class SearchAction(val text: String) : SearchUiAction
}

sealed interface SearchSideEffect : SideEffect
