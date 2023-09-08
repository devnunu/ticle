package com.devnunu.ticle.presentation.spending

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.asset.repository.AssetRepository
import kotlinx.coroutines.CoroutineScope

class SpendingViewModel(
    private val assetRepository: AssetRepository,
    initialState: SpendingState = SpendingState()
) : BaseViewModel<SpendingState, SpendingSideEffect, SpendingViewEvent>(initialState) {

    override fun collectDataFlow(scope: CoroutineScope) {
        super.collectDataFlow(scope)
        assetRepository.getSpendListFlow().setOnEach(scope) { userSpendingList ->
            copy(userSpendingList = userSpendingList)
        }
    }

    override fun onEvent(event: SpendingViewEvent) {
        super.onEvent(event)
        when (event) {
            SpendingViewEvent.OnClickBackPress -> {
                postSideEffect(SpendingSideEffect.GoBack)
            }

            SpendingViewEvent.OnClickAddSpendingIcon -> {
                postSideEffect(SpendingSideEffect.StartSpendingInput)
            }
        }
    }
}