package com.devnunu.ticle.presentation.spendingdetail

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.core.ui.components.dialog.DialogBtn
import com.devnunu.ticle.data.asset.repository.AssetRepository

class SpendingDetailViewModel(
    private val assetRepository: AssetRepository,
    initialState: SpendingDetailState = SpendingDetailState()
) : BaseViewModel<SpendingDetailState, SpendingDetailSideEffect, SpendingDetailViewEvent>(
    initialState
) {

    fun start(id: Int) {
        val userSpending = assetRepository.getSpendingItem(id)
        setState { copy(userSpending = userSpending) }
    }

    override fun onEvent(event: SpendingDetailViewEvent) {
        super.onEvent(event)
        when (event) {
            is SpendingDetailViewEvent.OnClickBackPress -> {
                postSideEffect(SpendingDetailSideEffect.GoBack)
            }

            is SpendingDetailViewEvent.OnClickDeleteText -> {
                setState { copy(dialogState = dialogState.open(SpendingDetailDialogTag.ItemDelete)) }
            }

            is SpendingDetailViewEvent.OnClickDeleteDialog -> {
                handleClickDeleteDialog(event.dialogBtn)
            }
        }
    }

    private fun handleClickDeleteDialog(dialogBtn: DialogBtn) {
        when (dialogBtn) {
            DialogBtn.POSITIVE -> {
                val id = state.value.userSpending?.id ?: return
                assetRepository.deleteSpendingItem(id)
                postSideEffect(SpendingDetailSideEffect.GoBack)
            }

            else -> Unit
        }
        setState { copy(dialogState = dialogState.close()) }
    }
}