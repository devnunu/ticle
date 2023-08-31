package com.devnunu.ticle.ui.home

import com.devnunu.ticle.base.BaseViewModel
import com.devnunu.ticle.base.EmptyState

class MainViewModel(
    initialState: EmptyState = EmptyState()
) : BaseViewModel<EmptyState, MainSideEffect, MainViewEvent>(initialState) {

    override fun onEvent(event: MainViewEvent) {
        when (event) {
            is MainViewEvent.ClickNextBtn -> {
                val budget = event.budget * 10000
                postSideEffect(MainSideEffect.StartDetailActivity(budget = budget))
            }
        }
    }
}