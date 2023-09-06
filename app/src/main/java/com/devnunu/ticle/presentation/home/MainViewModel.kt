package com.devnunu.ticle.presentation.home

import com.devnunu.ticle.base.BaseViewModel
import com.devnunu.ticle.base.EmptyState

class MainViewModel(
    initialState: EmptyState = EmptyState()
) : BaseViewModel<EmptyState, MainSideEffect, MainViewEvent>(initialState) {

    override fun onEvent(event: MainViewEvent) = when (event) {
        is MainViewEvent.OnClickIncomeBtn -> {
            postSideEffect(MainSideEffect.StartIncomeActivity)
        }
    }
}