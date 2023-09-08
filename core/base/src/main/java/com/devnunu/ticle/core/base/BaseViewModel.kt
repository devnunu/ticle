package com.devnunu.ticle.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel<STATE, SIDE_EFFECT, EVENT>(
    initialState: STATE
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = _state

    private val _sideEffects = MutableSharedFlow<SIDE_EFFECT>(extraBufferCapacity = 1)

    open fun collectDataFlow(scope: CoroutineScope) {}

    fun setState(reducer: STATE.() -> STATE) {
        _state.value = reducer(_state.value)
    }

    fun subscribeSideEffect(
        scope: CoroutineScope,
        handleSideEffect: (SIDE_EFFECT) -> Unit
    ) = _sideEffects.onEach { event ->
        handleSideEffect(event)
    }.launchIn(scope)

    fun postSideEffect(sideEffect: SIDE_EFFECT) {
        _sideEffects.tryEmit(sideEffect)
    }

    open fun onEvent(event: EVENT) {}

    protected open fun <T> Flow<T>.setOnEach(
        scope: CoroutineScope,
        reducer: STATE.(T) -> STATE
    ): Job {
        return onEach(scope) {
            setState { reducer(it) }
        }
    }

    protected open fun <T> Flow<T>.onEach(
        scope: CoroutineScope,
        action: suspend (T) -> Unit,
    ): Job {
        return onEach {
            action(it)
        }.launchIn(scope)
    }
}