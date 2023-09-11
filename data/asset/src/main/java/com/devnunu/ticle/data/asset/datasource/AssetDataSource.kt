package com.devnunu.ticle.data.asset.datasource

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.spending.UserSpending
import kotlinx.coroutines.flow.StateFlow

interface AssetDataSource {


    /**
     * Income
     * */
    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)

    fun getIncomeItem(id: Int): UserIncome?

    fun deleteIncomeItem(id: Int)

    /**
     * Income
     * */
    fun getSpendListFlow(): StateFlow<List<UserSpending>>

    fun addSpend(userIncome: UserSpending)

    fun getSpendingItem(id: Int): UserSpending?

    fun deleteSpendingItem(id: Int)
}