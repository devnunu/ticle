package com.devnunu.ticle.data.repository

import com.devnunu.ticle.data.datasource.AssetDataSource
import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.UserSpending
import kotlinx.coroutines.flow.StateFlow

class AssetRepositoryImpl(
    private val assetMemoryDataSource: AssetDataSource
) : AssetRepository {

    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> =
        assetMemoryDataSource.getIncomeListFlow()

    override fun addIncome(userIncome: UserIncome) {
        assetMemoryDataSource.addIncome(userIncome)
    }

    override fun getSpendListFlow(): StateFlow<List<UserSpending>> =
        assetMemoryDataSource.getSpendListFlow()

    override fun addSpend(userIncome: UserSpending) {
        assetMemoryDataSource.addSpend(userIncome)
    }
}