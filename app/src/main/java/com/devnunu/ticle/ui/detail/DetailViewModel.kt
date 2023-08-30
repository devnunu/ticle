package com.devnunu.ticle.ui.detail

import com.devnunu.ticle.base.BaseViewModel

class DetailViewModel(
    initialState: DetailState = DetailState()
) : BaseViewModel<DetailState, DetailSideEffect>(initialState) {

    fun setBudget(budget: Long) {
        setState { copy(budget = budget) }
    }
}