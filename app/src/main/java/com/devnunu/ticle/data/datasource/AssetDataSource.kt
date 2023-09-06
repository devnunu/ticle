package com.devnunu.ticle.data.datasource

import com.devnunu.ticle.model.UserIncome
import kotlinx.coroutines.flow.StateFlow

interface AssetDataSource {
    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)
}