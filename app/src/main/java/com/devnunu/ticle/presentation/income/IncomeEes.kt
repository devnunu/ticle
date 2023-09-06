package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.getTotalIncome
import com.devnunu.ticle.presentation.incomeinput.IncomeInputSideEffect
import com.devnunu.ticle.presentation.incomeinput.IncomeInputViewEvent
import com.devnunu.ticle.util.NumberFormatUtil

sealed class IncomeViewEvent {
    object OnClickBackPress : IncomeViewEvent()
    object OnClickAddIncomeIcon : IncomeViewEvent()
}

sealed class IncomeSideEffect {
    object GoBack : IncomeSideEffect()
    object StartIncomeInput : IncomeSideEffect()
}

data class IncomeState(
    val userIncomeList: List<UserIncome> = emptyList()
) {

    val totalIncomeText: String
        get() = NumberFormatUtil.toCurrencyFormText(userIncomeList.getTotalIncome())

}