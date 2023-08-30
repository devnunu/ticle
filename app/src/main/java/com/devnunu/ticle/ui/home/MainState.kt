package com.devnunu.ticle.ui.home

sealed class MainSideEffect {
    data class StartDetailActivity(val budget: Long) : MainSideEffect()
}

data class MainState(
    val temp: String? = null
) {

}