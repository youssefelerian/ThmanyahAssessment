package com.youssef.ui_core.core

import com.youssef.base.domain.interactor.AsyncUseCase
import com.youssef.base.presntation.viewmodel.uimodel.ErrorMessageUiModel
import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.network.domain.entity.ErrorEntity


suspend fun <I, R> AsyncUseCase<I, R>.collectToMutableState(
    input: I,
    update: (loading: LoadingState?, error: ErrorState?) -> Unit,
    isFullScreen: Boolean = true,
    language: String,
    success: (suspend (R) -> Unit),
    empty: (suspend () -> Unit) = {},
    error: (suspend (ErrorState) -> Boolean)? = null
) {
    showLoading(isFullScreen, update)
    return execute(input, success = {
        hideLoading(update)
        success.invoke(it)
    }, empty = {
        hideLoading(update)
        empty.invoke()
    }, error = {
        val errorState =
            if (isFullScreen) ErrorState.FullScreen(it.toUiModel(language)) else ErrorState.Dialog(
                it.toUiModel(language)
            )
        val isUpdate = error?.invoke(errorState) ?: true
        if (isUpdate) {
            update(null, errorState)
        }

    })
}

private fun showLoading(
    isFullScreen: Boolean,
    update: (loading: LoadingState?, error: ErrorState?) -> Unit
) {
    update(if (isFullScreen) LoadingState.FullScreen else LoadingState.Dialog, null)
}

private fun hideLoading(update: (loading: LoadingState?, error: ErrorState?) -> Unit) {
    update(null, null)
}

fun ErrorEntity.toUiModel(language: String) =
    ErrorMessageUiModel(
        title = "",
        message = throwable.message ?: "",
        code = code
    )