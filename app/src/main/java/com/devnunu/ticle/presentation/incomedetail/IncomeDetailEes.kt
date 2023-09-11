package com.devnunu.ticle.presentation.incomedetail

import com.devnunu.ticle.core.ui.components.bottomsheet.ModalState
import com.devnunu.ticle.core.ui.components.dialog.DialogBtn
import com.devnunu.ticle.model.asset.income.UserIncome

sealed class IncomeDetailViewEvent {
    object OnClickBackPress : IncomeDetailViewEvent()
    object OnClickDeleteText : IncomeDetailViewEvent()
    data class OnClickDeleteDialog(val dialogBtn: DialogBtn) : IncomeDetailViewEvent()
}

sealed class IncomeDetailSideEffect {
    object GoBack : IncomeDetailSideEffect()
}

sealed class IncomeDetailDialogTag {
    object ItemDelete : IncomeDetailDialogTag()
}

data class IncomeDetailState(
    val userIncome: UserIncome? = null,
    val dialogState: ModalState<IncomeDetailDialogTag> = ModalState.Closed(IncomeDetailDialogTag.ItemDelete)
) {
}