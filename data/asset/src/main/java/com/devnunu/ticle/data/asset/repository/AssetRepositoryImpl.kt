package com.devnunu.ticle.data.asset.repository

import com.devnunu.ticle.data.asset.datasource.AssetDataSource
import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.spending.UserSpending
import kotlinx.coroutines.flow.StateFlow

class AssetRepositoryImpl(
    private val assetMemoryDataSource: AssetDataSource
) : AssetRepository {

    /**
     * Income
     * */
    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> =
        assetMemoryDataSource.getIncomeListFlow()

    override fun addIncome(userIncome: UserIncome) {
        assetMemoryDataSource.addIncome(userIncome)
    }

    override fun getIncomeItem(id: Int): UserIncome? =
        assetMemoryDataSource.getIncomeItem(id)

    override fun deleteIncomeItem(id: Int) {
        assetMemoryDataSource.deleteIncomeItem(id)
    }

    /**
     * Spending
     * */
    override fun getSpendListFlow(): StateFlow<List<UserSpending>> =
        assetMemoryDataSource.getSpendListFlow()

    override fun addSpend(userIncome: UserSpending) {
        assetMemoryDataSource.addSpend(userIncome)
    }

    override fun getSpendingItem(id: Int): UserSpending? =
        assetMemoryDataSource.getSpendingItem(id)

    override fun deleteSpendingItem(id: Int) {
        assetMemoryDataSource.deleteSpendingItem(id)
    }
}