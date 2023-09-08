package com.devnunu.ticle.presentation.home

import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.getTotalIncome
import com.devnunu.ticle.util.NumberFormatUtil

sealed class MainViewEvent {
    object OnClickIncomeBtn : MainViewEvent()
    object OnClickSpendingBtn: MainViewEvent()

}

sealed class MainSideEffect {
    object StartIncomeActivity : MainSideEffect()
    object StartSpendingActivity : MainSideEffect()
}

data class MainState(
    val userIncomeList: List<UserIncome> = emptyList()
) {

    val totalIncomeText: String
        get() = NumberFormatUtil.toCurrencyFormText(userIncomeList.getTotalIncome())

}