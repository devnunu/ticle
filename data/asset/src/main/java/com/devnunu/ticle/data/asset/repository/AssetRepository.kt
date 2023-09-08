package com.devnunu.ticle.data.asset.repository

import com.devnunu.ticle.model.asset.UserIncome
import com.devnunu.ticle.model.asset.UserSpending
import kotlinx.coroutines.flow.StateFlow

interface AssetRepository {

    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)

    fun getSpendListFlow(): StateFlow<List<UserSpending>>

    fun addSpend(userIncome: UserSpending)
}