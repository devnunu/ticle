package com.devnunu.ticle.data.repository

import com.devnunu.ticle.data.datasource.AssetDataSource
import com.devnunu.ticle.model.UserIncome
import kotlinx.coroutines.flow.StateFlow

class AssetRepositoryImpl(
    private val assetMemoryDataSource: AssetDataSource
) : AssetRepository {

    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> =
        assetMemoryDataSource.getIncomeListFlow()

    override fun addIncome(userIncome: UserIncome) {
        assetMemoryDataSource.addIncome(userIncome)
    }
}