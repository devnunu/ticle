package com.devnunu.ticle.presentation.detail

import com.devnunu.ticle.base.BaseViewModel

class DetailViewModel(
    initialState: DetailState = DetailState()
) : BaseViewModel<DetailState, DetailSideEffect, DetailViewEvent>(initialState) {

    fun setBudget(budget: Long) {
        setState { copy(budget = budget) }
    }
}