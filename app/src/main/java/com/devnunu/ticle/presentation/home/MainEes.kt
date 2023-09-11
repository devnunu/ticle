package com.devnunu.ticle.presentation.home

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.spending.UserSpending
import com.devnunu.ticle.model.asset.income.getTotalIncome
import com.devnunu.ticle.model.asset.spending.getTotalSpending
import com.devnunu.ticle.util.NumberFormatUtil

sealed class MainViewEvent {
    object OnClickIncomeBtn : MainViewEvent()
    object OnClickSpendingBtn : MainViewEvent()

}

sealed class MainSideEffect {
    object StartIncomeActivity : MainSideEffect()
    object StartSpendingActivity : MainSideEffect()
}

data class MainState(
    val userIncomeList: List<UserIncome> = emptyList(),
    val userSpendingList: List<UserSpending> = emptyList()
) {

    val totalIncomeText: String
        get() = NumberFormatUtil.toCurrencyFormText(userIncomeList.getTotalIncome())

    val totalSpendingText: String
        get() = NumberFormatUtil.toCurrencyFormText(userSpendingList.getTotalSpending())

    val totalSummaryText: String
        get() = NumberFormatUtil.toCurrencyFormText(userIncomeList.getTotalIncome() - userSpendingList.getTotalSpending())
}