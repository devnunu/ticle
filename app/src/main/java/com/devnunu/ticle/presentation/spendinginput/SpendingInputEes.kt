package com.devnunu.ticle.presentation.spendinginput


sealed class SpendingInputViewEvent {
    object OnClickBackPress : SpendingInputViewEvent()
    data class OnClickCompleteBtn(
        val spendingName: String,
        val spending: Long
    ) : SpendingInputViewEvent()
}

sealed class SpendingInputSideEffect {
    object GoBack : SpendingInputSideEffect()
    object CompleteAddSpending : SpendingInputSideEffect()
}

data class SpendingInputState(
    val temp: String? = null
) {

}