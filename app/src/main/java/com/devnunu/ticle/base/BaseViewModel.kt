package com.devnunu.ticle.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnunu.ticle.ui.home.MainState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

open class BaseViewModel<STATE, SIDE_EFFECT>(
    initialState: STATE
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = _state

    private val _sideEffects = MutableSharedFlow<SIDE_EFFECT>(extraBufferCapacity = 1)

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
}