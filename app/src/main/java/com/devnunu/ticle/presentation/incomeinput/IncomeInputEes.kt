package com.devnunu.ticle.presentation.incomeinput

import com.devnunu.ticle.presentation.income.IncomeSideEffect

sealed class IncomeInputViewEvent {
    object OnClickBackPress : IncomeInputViewEvent()
    data class OnClickCompleteBtn(
        val incomeName: String,
        val budget: Long
    ) : IncomeInputViewEvent()
}

sealed class IncomeInputSideEffect {
    object GoBack : IncomeInputSideEffect()
    object CompleteAddIncome : IncomeInputSideEffect()
}

data class IncomeInputState(
    val incomeValue: Long? = null
) {

}