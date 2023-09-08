package com.devnunu.ticle.presentation.home

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.repository.AssetRepository
import kotlinx.coroutines.CoroutineScope

class MainViewModel(
    private val assetRepository: AssetRepository,
    initialState: MainState = MainState()
) : BaseViewModel<MainState, MainSideEffect, MainViewEvent>(initialState) {

    override fun collectDataFlow(scope: CoroutineScope) {
        assetRepository.getIncomeListFlow().setOnEach(scope) { userIncomeList ->
            copy(userIncomeList = userIncomeList)
        }
    }

    override fun onEvent(event: MainViewEvent) = when (event) {
        is MainViewEvent.OnClickIncomeBtn -> {
            postSideEffect(MainSideEffect.StartIncomeActivity)
        }
        is MainViewEvent.OnClickSpendingBtn-> {
            postSideEffect(MainSideEffect.StartSpendingActivity)
        }
    }
}