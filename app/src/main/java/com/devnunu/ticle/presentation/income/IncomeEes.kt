package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.income.getTotalIncome
import com.devnunu.ticle.util.NumberFormatUtil

sealed class IncomeViewEvent {
    object OnClickBackPress : IncomeViewEvent()
    object OnClickAddIncomeIcon : IncomeViewEvent()
    data class OnClickIncomeItemView(val id: Int?) : IncomeViewEvent()
}

sealed class IncomeSideEffect {
    object GoBack : IncomeSideEffect()
    object StartIncomeInput : IncomeSideEffect()
    data class StartIncomeDetail(val id: Int?) : IncomeSideEffect()
}

data class IncomeState(
    val userIncomeList: List<UserIncome> = emptyList()
) {

    val totalIncomeText: String
        get() = NumberFormatUtil.toCurrencyFormText(userIncomeList.getTotalIncome())

}