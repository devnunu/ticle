package com.devnunu.ticle.data.datasource

import androidx.lifecycle.LiveData
import com.devnunu.ticle.model.UserIncome
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AssetMemoryDataSourceImpl : AssetDataSource {

    private val _incomeListFlow = MutableStateFlow<List<UserIncome>>(emptyList())

    override fun getIncomeListFlow(): StateFlow<List<UserIncome>> = _incomeListFlow

    override fun addIncome(userIncome: UserIncome) {
        val incomeList = _incomeListFlow.value.toMutableList()
        incomeList.add(userIncome)
        _incomeListFlow.value = incomeList
    }
}