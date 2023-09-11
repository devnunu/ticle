package com.devnunu.ticle.presentation.incomedetail

import com.devnunu.ticle.core.base.BaseViewModel
import com.devnunu.ticle.core.ui.components.dialog.DialogBtn
import com.devnunu.ticle.data.asset.repository.AssetRepository

class IncomeDetailViewModel(
    private val assetRepository: AssetRepository,
    initialState: IncomeDetailState = IncomeDetailState()
) : BaseViewModel<IncomeDetailState, IncomeDetailSideEffect, IncomeDetailViewEvent>(initialState) {

    fun start(incomeId: Int) {
        val userIncome = assetRepository.getIncomeItem(incomeId)
        setState { copy(userIncome = userIncome) }
    }

    override fun onEvent(event: IncomeDetailViewEvent) {
        super.onEvent(event)
        when (event) {
            is IncomeDetailViewEvent.OnClickBackPress -> {
                postSideEffect(IncomeDetailSideEffect.GoBack)
            }

            is IncomeDetailViewEvent.OnClickDeleteText -> {
                setState { copy(dialogState = dialogState.open(IncomeDetailDialogTag.ItemDelete)) }
            }

            is IncomeDetailViewEvent.OnClickDeleteDialog -> {
                handleClickDeleteDialog(event.dialogBtn)
            }
        }
    }

    private fun handleClickDeleteDialog(dialogBtn: DialogBtn) {
        when (dialogBtn) {
            DialogBtn.POSITIVE -> {
                val id = state.value.userIncome?.id ?: return
                assetRepository.deleteIncomeItem(id)
                postSideEffect(IncomeDetailSideEffect.GoBack)
            }

            else -> Unit
        }
        setState { copy(dialogState = dialogState.close()) }
    }
}