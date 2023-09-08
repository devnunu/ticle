package com.devnunu.ticle.presentation.incomeinput

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.repository.AssetRepository
import com.devnunu.ticle.model.UserIncome

class IncomeInputViewModel(
    private val assetRepository: AssetRepository,
    initialState: IncomeInputState = IncomeInputState()
) : BaseViewModel<IncomeInputState, IncomeInputSideEffect, IncomeInputViewEvent>(initialState) {

    override fun onEvent(event: IncomeInputViewEvent) {
        super.onEvent(event)
        when (event) {
            is IncomeInputViewEvent.OnClickBackPress -> {
                postSideEffect(IncomeInputSideEffect.GoBack)
            }

            is IncomeInputViewEvent.OnClickCompleteBtn -> {
                val userIncome = getUserIncome(event.incomeName, event.budget)
                assetRepository.addIncome(userIncome)
                postSideEffect(IncomeInputSideEffect.CompleteAddIncome)
            }
        }
    }

    private fun getUserIncome(incomeName: String, budget: Long) =
        UserIncome(name = incomeName, value = budget)
}