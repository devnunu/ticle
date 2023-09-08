package com.devnunu.ticle.model.asset

import com.devnunu.ticle.util.NumberFormatUtil

data class UserSpending(
    val name: String,
    val value: Long
) {
    val formattedValueText: String
        get() = NumberFormatUtil.toCurrencyFormText(value)
}

fun List<UserSpending>.getTotalSpending() =
    this.sumOf { it.value }