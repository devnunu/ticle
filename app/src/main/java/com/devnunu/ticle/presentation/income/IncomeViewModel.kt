package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.base.BaseViewModel
import com.devnunu.ticle.data.repository.AssetRepository
import kotlinx.coroutines.CoroutineScope

class IncomeViewModel(
    private val assetRepository: AssetRepository,
    initialState: IncomeState = IncomeState()
) : BaseViewModel<IncomeState, IncomeSideEffect, IncomeViewEvent>(initialState) {


    override fun collectDataFlow(scope: CoroutineScope) {
        assetRepository.getIncomeListFlow().setOnEach(scope) { userIncomeList ->
            copy(userIncomeList = userIncomeList)
        }
    }

    override fun onEvent(event: IncomeViewEvent) {
        super.onEvent(event)
        when (event) {
            IncomeViewEvent.OnClickBackPress -> {
                postSideEffect(IncomeSideEffect.GoBack)
            }

            IncomeViewEvent.OnClickAddIncomeIcon -> {
                postSideEffect(IncomeSideEffect.StartIncomeInput)
            }
        }
    }
}