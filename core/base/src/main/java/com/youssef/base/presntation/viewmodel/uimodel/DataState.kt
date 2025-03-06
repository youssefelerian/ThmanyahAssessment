package com.youssef.base.presntation.viewmodel.uimodel

sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Empty<T>(val emptyString: String? = null) : DataState<T>()
}
