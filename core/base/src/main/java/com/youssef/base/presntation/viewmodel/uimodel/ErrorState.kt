package com.youssef.base.presntation.viewmodel.uimodel


sealed class ErrorState(val code: Int, var uiAction: UiAction?) {
    class FullScreen(val error: ErrorMessageUiModel, uiAction: UiAction? = null) :
        ErrorState(error.code, uiAction)

    class Dialog(val error: ErrorMessageUiModel, uiAction: UiAction? = null) :
        ErrorState(error.code, uiAction)

    class MultipleError(
        code: Int,
        val data: List<ErrorMessageUiModel>,
        uiAction: UiAction? = null
    ) : ErrorState(code, uiAction)

    class InputsErrors(
        code: Int = -1,
        val type: Int = 0,
        val message: String,
        uiAction: UiAction? = null
    ) : ErrorState(code, uiAction)
}
