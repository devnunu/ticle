package com.devnunu.ticle.data.asset.repository

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.spending.UserSpending
import kotlinx.coroutines.flow.StateFlow

interface AssetRepository {

    /**
     * Income
     * */
    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)

    fun getIncomeItem(id: Int): UserIncome?

    fun deleteIncomeItem(id: Int)

    /**
     * Spending
     * */
    fun getSpendListFlow(): StateFlow<List<UserSpending>>

    fun addSpend(userIncome: UserSpending)

    fun getSpendingItem(id: Int): UserSpending?

    fun deleteSpendingItem(id: Int)
}