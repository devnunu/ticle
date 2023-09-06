package com.devnunu.ticle.presentation.income

import com.devnunu.ticle.model.UserIncome

sealed class IncomeViewEvent {
    object OnClickBackPress : IncomeViewEvent()
}

sealed class IncomeSideEffect {
    object GoBack : IncomeSideEffect()
}

data class IncomeState(
    val userIncomeList: List<UserIncome> = emptyList()
) {

}