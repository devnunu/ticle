package com.devnunu.ticle.ui.home

sealed class MainSideEffect {
    data class StartDetailActivity(val budget: Long) : MainSideEffect()
}

sealed class MainViewEvent {
    data class ClickNextBtn(val budget: Long) : MainViewEvent()
}

data class MainState(
    val temp: String? = null
) {

}