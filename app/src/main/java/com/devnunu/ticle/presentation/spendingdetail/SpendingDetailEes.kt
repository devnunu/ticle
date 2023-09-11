package com.devnunu.ticle.presentation.spendingdetail

import com.devnunu.ticle.core.ui.components.bottomsheet.ModalState
import com.devnunu.ticle.core.ui.components.dialog.DialogBtn
import com.devnunu.ticle.model.asset.spending.UserSpending

sealed class SpendingDetailViewEvent {
    object OnClickBackPress : SpendingDetailViewEvent()
    object OnClickDeleteText : SpendingDetailViewEvent()
    data class OnClickDeleteDialog(val dialogBtn: DialogBtn) : SpendingDetailViewEvent()
}

sealed class SpendingDetailSideEffect {
    object GoBack : SpendingDetailSideEffect()
}

sealed class SpendingDetailDialogTag {
    object ItemDelete : SpendingDetailDialogTag()
}

data class SpendingDetailState(
    val userSpending: UserSpending? = null,
    val dialogState: ModalState<SpendingDetailDialogTag> = ModalState.Closed(SpendingDetailDialogTag.ItemDelete)
) {

}