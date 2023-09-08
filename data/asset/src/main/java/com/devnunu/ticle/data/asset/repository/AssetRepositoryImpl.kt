package com.devnunu.ticle.data.asset.repository

import com.devnunu.ticle.data.asset.datasource.AssetDataSource
import com.devnunu.ticle.model.asset.UserIncome
import com.devnunu.ticle.model.asset.UserSpending
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