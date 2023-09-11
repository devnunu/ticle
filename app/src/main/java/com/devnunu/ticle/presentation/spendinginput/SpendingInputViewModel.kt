package com.devnunu.ticle.presentation.spendinginput

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.data.asset.repository.AssetRepository
import com.devnunu.ticle.model.asset.spending.SpendingType
import com.devnunu.ticle.model.asset.spending.UserSpending

class SpendingInputViewModel(
    private val assetRepository: AssetRepository,
    initialState: SpendingInputState = SpendingInputState()
) : BaseViewModel<SpendingInputState, SpendingInputSideEffect, SpendingInputViewEvent>(initialState) {

    override fun onEvent(event: SpendingInputViewEvent) {
        super.onEvent(event)
        when (event) {
            is SpendingInputViewEvent.OnClickBackPress -> {
                postSideEffect(SpendingInputSideEffect.GoBack)
            }

            is SpendingInputViewEvent.OnClickCompleteBtn -> {
                val spendingType = state.value.spendingType ?: return
                val userSpending = getUserSpending(event.spendingName, spendingType, event.spending)
                assetRepository.addSpend(userSpending)
                postSideEffect(SpendingInputSideEffect.CompleteAddSpending)
            }

            is SpendingInputViewEvent.OnCloseBottomSheet -> {
                onCloseBottomSheet()
            }

            is SpendingInputViewEvent.OnClickSpendingTypeSelectInput -> {
                onOpenBottomSheet(SpendingInputBottomSheetTag.SpendingType)
            }

            is SpendingInputViewEvent.OnClickSpendingTypeBottomSheetItem -> {
                setState { copy(spendingType = event.spendingType) }
                onCloseBottomSheet()
            }
        }
    }

    private fun getUserSpending(spendingName: String, spendingType: SpendingType, spending: Long) =
        UserSpending(name = spendingName, type = spendingType, value = spending)

    /**
     * BottomSheet
     * */
    private fun onCloseBottomSheet() {
        setState { copy(bottomSheetState = bottomSheetState.close()) }
    }

    private fun onOpenBottomSheet(tag: SpendingInputBottomSheetTag) {
        setState { copy(bottomSheetState = bottomSheetState.open(tag)) }
    }
}