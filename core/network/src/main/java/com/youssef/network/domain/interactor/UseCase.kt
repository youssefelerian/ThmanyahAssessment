package com.youssef.network.domain.interactor

import com.youssef.network.domain.entity.ErrorEntity
import com.youssef.network.domain.entity.Outcome

interface UseCase<R> {
    suspend fun onSuccess(success: Outcome.Success<R>)
    suspend fun onEmpty()
    suspend fun onError(error: ErrorEntity)
}