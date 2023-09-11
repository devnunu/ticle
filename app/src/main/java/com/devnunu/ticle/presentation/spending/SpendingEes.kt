package com.devnunu.ticle.presentation.spending

import com.devnunu.ticle.model.asset.spending.UserSpending
import com.devnunu.ticle.model.asset.spending.getTotalSpending
import com.devnunu.ticle.util.NumberFormatUtil

sealed class SpendingViewEvent {
    object OnClickBackPress : SpendingViewEvent()
    object OnClickAddSpendingIcon : SpendingViewEvent()
    data class OnClickSpendingItem(val id: Int?) : SpendingViewEvent()
}

sealed class SpendingSideEffect {
    object GoBack : SpendingSideEffect()
    object StartSpendingInput : SpendingSideEffect()
    data class StartSpendingDetail(val id: Int?) : SpendingSideEffect()
}

data class SpendingState(
    val userSpendingList: List<UserSpending> = emptyList()
) {
    val totalSpendingText: String
        get() = NumberFormatUtil.toCurrencyFormText(userSpendingList.getTotalSpending())
}