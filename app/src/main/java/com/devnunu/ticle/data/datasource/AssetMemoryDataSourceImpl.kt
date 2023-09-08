package com.devnunu.ticle.data.datasource

import androidx.lifecycle.LiveData
import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.UserSpending
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AssetMemoryDataSourceImpl : AssetDataSource {

    private val _incomeListFlow = MutableStateFlow<List<UserIncome>>(emptyList())

    private val _spendListFlow = MutableStateFlow<List<UserSpending>>(emptyList())

    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> = _incomeListFlow

    override fun addIncome(userIncome: UserIncome) {
        val incomeList = _incomeListFlow.value.toMutableList()
        incomeList.add(userIncome)
        _incomeListFlow.value = incomeList
    }

    override fun getSpendListFlow(): StateFlow<List<UserSpending>> = _spendListFlow

    override fun addSpend(userIncome: UserSpending) {
        val spendList = _spendListFlow.value.toMutableList()
        spendList.add(userIncome)
        _spendListFlow.value = spendList
    }
}