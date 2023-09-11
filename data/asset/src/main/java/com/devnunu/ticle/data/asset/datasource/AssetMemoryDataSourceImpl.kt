package com.devnunu.ticle.data.asset.datasource

import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.model.asset.income.getNewIncomeId
import com.devnunu.ticle.model.asset.spending.UserSpending
import com.devnunu.ticle.model.asset.spending.getNewSpendingId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AssetMemoryDataSourceImpl : AssetDataSource {

    private val _incomeListFlow = MutableStateFlow<List<UserIncome>>(emptyList())

    private val _spendListFlow = MutableStateFlow<List<UserSpending>>(emptyList())

    /**
     * Income
     * */
    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> = _incomeListFlow

    override fun addIncome(userIncome: UserIncome) {
        val incomeList = _incomeListFlow.value.toMutableList()
        incomeList.add(userIncome.copy(id = incomeList.getNewIncomeId()))
        _incomeListFlow.value = incomeList
    }

    override fun getIncomeItem(id: Int): UserIncome? =
        _incomeListFlow.value.find { it.id == id }

    override fun deleteIncomeItem(id: Int) {
        val incomeList = _incomeListFlow.value.toMutableList()
        incomeList.removeIf { it.id == id }
        _incomeListFlow.value = incomeList
    }

    /**
     * Spending
     * */
    override fun getSpendListFlow(): StateFlow<List<UserSpending>> = _spendListFlow

    override fun addSpend(userIncome: UserSpending) {
        val spendingList = _spendListFlow.value.toMutableList()
        spendingList.add(userIncome.copy(id = spendingList.getNewSpendingId()))
        _spendListFlow.value = spendingList
    }

    override fun getSpendingItem(id: Int): UserSpending? =
        _spendListFlow.value.find { it.id == id }

    override fun deleteSpendingItem(id: Int) {
        val spendList = _spendListFlow.value.toMutableList()
        spendList.removeIf { it.id == id }
        _spendListFlow.value = spendList
    }
}