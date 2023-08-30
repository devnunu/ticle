package com.devnunu.ticle.ui.home

import com.devnunu.ticle.base.BaseViewModel

class MainViewModel(
    initialState: MainState = MainState()
) : BaseViewModel<MainState, MainSideEffect>(initialState) {

    fun onClickNextBtn(budget: Long) {
        val budget = budget * 10000
        postSideEffect(MainSideEffect.StartDetailActivity(budget = budget))
    }
}