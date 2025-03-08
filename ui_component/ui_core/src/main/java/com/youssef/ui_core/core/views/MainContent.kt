package com.youssef.ui_core.core.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.youssef.base.presntation.viewmodel.uimodel.ErrorState
import com.youssef.base.presntation.viewmodel.uimodel.LoadingState
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState
import com.youssef.ui_core.core.dialog.ShowErrorAlert
import com.youssef.ui_core.core.error.ErrorFullScreen
import com.youssef.ui_core.core.loading.FullLoading
import com.youssef.ui_core.core.loading.LoadingDialog

@Composable
fun MainContent(
    modifier: Modifier,
    modifierContent: Modifier = Modifier
        .fillMaxSize(),
    uiState: UiState,
    toolbar: @Composable () -> Unit = {},
    content: @Composable ColumnScope.(error: ErrorState.InputsErrors?) -> Unit,
    retryAction: ((uiAction: UiAction) -> Unit)? = null,
    dismissAlertError: ((error: ErrorState) -> Unit)? = null,
) {
    Column(modifier = modifier) {
        val loading = uiState.loadingState
        val errorState = uiState.errorState
        if (loading is LoadingState.FullScreen || errorState is ErrorState.FullScreen) {
            if (loading == LoadingState.FullScreen) {
                FullLoading(Modifier
                    .fillMaxSize()
                    .weight(1f))
            } else if (errorState is ErrorState.FullScreen) {
                toolbar()
                ErrorFullScreen(
                    Modifier
                        .fillMaxSize()
                        .weight(1f),
                    title = errorState.error.title,
                    message = errorState.error.message,
                    retryAction = if (retryAction != null && errorState.uiAction != null) {
                        { retryAction.invoke(errorState.uiAction!!) }
                    } else null
                )
            }
        } else {
            OnContent(
                modifierContent,
                toolbar,
                content,
                dismissAlertError,
                showLoadingDialog = loading is LoadingState.Dialog,
                errorState = errorState
            )
        }
    }
}

@Composable
private fun OnContent(
    modifierContent: Modifier,
    toolbar: @Composable () -> Unit = {},
    content: @Composable ColumnScope.(error: ErrorState.InputsErrors?) -> Unit,
    dismissAlertError: ((error: ErrorState) -> Unit)?,
    showLoadingDialog: Boolean = false,
    errorState: ErrorState? = null
) {
    Column(modifierContent) {
        toolbar()
        content((errorState as? ErrorState.InputsErrors))
        if (showLoadingDialog) {
            LoadingDialog()
        }
        if (errorState is ErrorState.Dialog) {
            ShowErrorAlert(
                true,
                title = errorState.error.title,
                message = errorState.error.message,
                onDismiss = { dismissAlertError?.invoke(errorState) }
            )
        }

        var padding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        if (padding.value == 0f) {
            padding = 45.dp
        }
        SpacerVertical(padding)
    }
}