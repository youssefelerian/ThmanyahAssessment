package com.youssef.base.presntation.viewmodel.uimodel

sealed class LoadingState {
    data object FullScreen : LoadingState()
    data object Dialog : LoadingState()
}