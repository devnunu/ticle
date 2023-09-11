package com.devnunu.ticle.model.asset.income

import com.devnunu.ticle.util.NumberFormatUtil

data class UserIncome(
    val id: Int? = null,
    val name: String,
    val value: Long
) {
    val formattedValueText: String
        get() = NumberFormatUtil.toCurrencyFormText(value)
}

fun List<UserIncome>.getTotalIncome() =
    this.sumOf { it.value }

fun List<UserIncome>.getNewIncomeId() =
    this.maxByOrNull { it.id ?: 0 }?.id?.plus(1) ?: 0