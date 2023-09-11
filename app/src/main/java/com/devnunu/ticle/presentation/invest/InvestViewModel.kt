package com.devnunu.ticle.presentation.invest

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.asset.repository.AssetRepository
import kotlinx.coroutines.CoroutineScope

class InvestViewModel(
    private val assetRepository: AssetRepository,
    initialState: InvestState = InvestState()
) : BaseViewModel<InvestState, InvestSideEffect, InvestViewEvent>(initialState) {

    override fun collectDataFlow(scope: CoroutineScope) {
        assetRepository.getIncomeListFlow().setOnEach(scope) { userIncomeList ->
            copy(userIncomeList = userIncomeList)
        }

        assetRepository.getSpendListFlow().setOnEach(scope) { userSpendingList ->
            copy(userSpendingList = userSpendingList)
        }
    }

    override fun onEvent(event: InvestViewEvent) {
        super.onEvent(event)
        when (event) {
            is InvestViewEvent.OnClickBackPress -> {
                postSideEffect(InvestSideEffect.GoBack)
            }
        }
    }
}