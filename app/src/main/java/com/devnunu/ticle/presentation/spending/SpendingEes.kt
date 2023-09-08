package com.devnunu.ticle.presentation.spending

import com.devnunu.ticle.model.UserSpending
import com.devnunu.ticle.model.getTotalSpending
import com.devnunu.ticle.util.NumberFormatUtil

sealed class SpendingViewEvent {
    object OnClickBackPress : SpendingViewEvent()
    object OnClickAddSpendingIcon : SpendingViewEvent()
}

sealed class SpendingSideEffect {
    object GoBack : SpendingSideEffect()
    object StartSpendingInput : SpendingSideEffect()
}

data class SpendingState(
    val userSpendingList: List<UserSpending> = emptyList()
) {
    val totalSpendingText: String
        get() = NumberFormatUtil.toCurrencyFormText(userSpendingList.getTotalSpending())
}