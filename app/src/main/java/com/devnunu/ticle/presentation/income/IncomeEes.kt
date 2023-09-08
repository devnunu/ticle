package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.model.asset.UserIncome
import com.devnunu.ticle.model.asset.getTotalIncome
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