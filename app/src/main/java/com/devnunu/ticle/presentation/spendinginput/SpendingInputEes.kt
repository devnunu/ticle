package com.devnunu.ticle.presentation.spendinginput

import com.devnunu.ticle.core.ui.components.bottomsheet.ModalState
import com.devnunu.ticle.model.asset.spending.SpendingType


sealed class SpendingInputViewEvent {
    object OnClickBackPress : SpendingInputViewEvent()
    data class OnClickCompleteBtn(
        val spendingName: String,
        val spending: Long
    ) : SpendingInputViewEvent()

    object OnCloseBottomSheet : SpendingInputViewEvent()
    data class OnClickSpendingTypeBottomSheetItem(val spendingType: SpendingType) :
        SpendingInputViewEvent()

    object OnClickSpendingTypeSelectInput : SpendingInputViewEvent()
}

sealed class SpendingInputSideEffect {
    object GoBack : SpendingInputSideEffect()
    object CompleteAddSpending : SpendingInputSideEffect()
}

sealed class SpendingInputBottomSheetTag {
    object SpendingType : SpendingInputBottomSheetTag()
}

data class SpendingInputState(
    val spendingType: SpendingType? = null,
    val bottomSheetState: ModalState<SpendingInputBottomSheetTag> =
        ModalState.Closed(SpendingInputBottomSheetTag.SpendingType)
)