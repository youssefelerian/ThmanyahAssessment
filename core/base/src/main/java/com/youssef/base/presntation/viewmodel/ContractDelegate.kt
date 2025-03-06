package com.youssef.base.presntation.viewmodel

import com.youssef.base.presntation.viewmodel.uimodel.IContract
import com.youssef.base.presntation.viewmodel.uimodel.SideEffect
import com.youssef.base.presntation.viewmodel.uimodel.UiAction
import com.youssef.base.presntation.viewmodel.uimodel.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContractDelegate<State : UiState, Action : UiAction, Effect : SideEffect> internal constructor(
    initialUiState: State,
) : IContract<State, Action, Effect> {

    private val _uiState = MutableStateFlow(initialUiState)
    override val uiState: StateFlow<State> = _uiState.asStateFlow()

    private val _sideEffect by lazy { Channel<Effect>() }
    override val sideEffect: Flow<Effect> by lazy { _sideEffect.receiveAsFlow() }

    override fun onAction(uiAction: Action) {}

    override fun updateUiState(newUiState: State) {
        _uiState.update { newUiState }
    }

    override fun updateUiState(block: State.() -> State) {
        _uiState.update(block)
    }

    override fun CoroutineScope.emitSideEffect(effect: Effect) {
        this.launch { _sideEffect.send(effect) }
    }

    override fun emitEffect(coroutineScope: CoroutineScope, effect: Effect) {
        coroutineScope.emitSideEffect(effect)
    }
}

fun <State : UiState, Action : UiAction, Effect : SideEffect> delegate(
    initialUiState: State,
): IContract<State, Action, Effect> = ContractDelegate(initialUiState)
