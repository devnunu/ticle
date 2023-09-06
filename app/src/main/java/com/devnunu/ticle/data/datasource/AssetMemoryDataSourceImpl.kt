package com.devnunu.ticle.data.datasource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AssetMemoryDataSourceImpl : AssetDataSource {

    private val _budget = MutableStateFlow<Long?>(null)
    val budget: StateFlow<Long?> = _budget

    private fun setBudget(budget: Long) {
        _budget.value = budget
    }
}