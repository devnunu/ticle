package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.asset.repository.AssetRepository
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
            is IncomeViewEvent.OnClickBackPress -> {
                postSideEffect(IncomeSideEffect.GoBack)
            }

            is IncomeViewEvent.OnClickAddIncomeIcon -> {
                postSideEffect(IncomeSideEffect.StartIncomeInput)
            }
            is IncomeViewEvent.OnClickIncomeItemView-> {
                postSideEffect(IncomeSideEffect.StartIncomeDetail(event.id))
            }
        }
    }
}