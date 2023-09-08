package com.devnunu.ticle.data.datasource

import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.UserSpending
import kotlinx.coroutines.flow.StateFlow

interface AssetDataSource {
    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)

    fun getSpendListFlow(): StateFlow<List<UserSpending>>

    fun addSpend(userIncome: UserSpending)
}