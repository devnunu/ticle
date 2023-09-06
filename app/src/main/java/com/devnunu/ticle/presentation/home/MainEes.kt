package com.devnunu.ticle.presentation.home

sealed class MainViewEvent {
    object OnClickIncomeBtn : MainViewEvent()

}

sealed class MainSideEffect {
    object StartIncomeActivity : MainSideEffect()
}

data class MainState(
    val temp: String? = null
) {

}