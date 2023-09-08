package com.devnunu.ticle.model.asset

import com.devnunu.ticle.util.NumberFormatUtil

data class UserIncome(
    val name: String,
    val value: Long
) {
    val formattedValueText: String
        get() = NumberFormatUtil.toCurrencyFormText(value)
}

fun List<UserIncome>.getTotalIncome() =
    this.sumOf { it.value }