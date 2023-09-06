package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.base.BaseViewModel

class IncomeViewModel(
    initialState: IncomeState = IncomeState()
) : BaseViewModel<IncomeState, IncomeSideEffect, IncomeViewEvent>(initialState) {

    override fun onEvent(event: IncomeViewEvent) {
        super.onEvent(event)
        when (event) {
            IncomeViewEvent.OnClickBackPress -> {
                postSideEffect(IncomeSideEffect.GoBack)
            }
        }
    }
}