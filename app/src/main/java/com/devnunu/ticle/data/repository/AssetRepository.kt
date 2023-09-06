package com.devnunu.ticle.data.repository

import com.devnunu.ticle.data.datasource.AssetDataSource
import com.devnunu.ticle.model.UserIncome
import kotlinx.coroutines.flow.StateFlow

interface AssetRepository {

    fun getIncomeListFlow(): StateFlow<List<UserIncome>>

    fun addIncome(userIncome: UserIncome)
}