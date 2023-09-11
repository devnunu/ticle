package com.devnunu.ticle.presentation.invest

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.income.getTotalIncome
import com.devnunu.ticle.model.asset.spending.UserSpending
import com.devnunu.ticle.model.asset.spending.getTotalSpending
import com.devnunu.ticle.util.NumberFormatUtil

sealed class InvestViewEvent {
    object OnClickBackPress : InvestViewEvent()
}

sealed class InvestSideEffect {
    object GoBack : InvestSideEffect()
}

data class InvestState(
    val userIncomeList: List<UserIncome> = emptyList(),
    val userSpendingList: List<UserSpending> = emptyList()
) {
    val spareMoney: Long
        get() = userIncomeList.getTotalIncome() - userSpendingList.getTotalSpending()
    val totalSummaryText: String
        get() = NumberFormatUtil.toCurrencyFormText(spareMoney)
}