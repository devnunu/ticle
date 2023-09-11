package com.devnunu.ticle.model.asset.spending

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.util.NumberFormatUtil

data class UserSpending(
    val id: Int? = null,
    val name: String,
    val value: Long
) {
    val formattedValueText: String
        get() = NumberFormatUtil.toCurrencyFormText(value)
}

fun List<UserSpending>.getTotalSpending() =
    this.sumOf { it.value }

fun List<UserSpending>.getNewSpendingId() =
    this.maxByOrNull { it.id ?: 0 }?.id?.plus(1) ?: 0