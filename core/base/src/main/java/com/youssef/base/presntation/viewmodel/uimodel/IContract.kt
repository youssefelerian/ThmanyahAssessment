package com.youssef.base.presntation.viewmodel.uimodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IContract<State : UiState, Action : UiAction, Effect : SideEffect> {
    val uiState: StateFlow<State>
    val sideEffect: Flow<Effect>

    fun getState(): State = uiState.value

    fun onAction(uiAction: Action)

    fun updateUiState(block: State.() -> State)

    fun updateUiState(newUiState: State)

    fun CoroutineScope.emitSideEffect(effect: Effect)

    fun emitEffect(coroutineScope: CoroutineScope, effect: Effect)
}

interface UiState {
    val loadingState: LoadingState?
    val errorState: ErrorState?
}

interface UiAction {

}

interface SideEffect

@Stable
@Composable
fun <State : UiState, Action : UiAction, Effect : SideEffect> IContract<State, Action, Effect>.unpack() =
    Triple(uiState.collectAsState().value, ::onAction, sideEffect)